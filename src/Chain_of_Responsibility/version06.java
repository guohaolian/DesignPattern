package Chain_of_Responsibility;

import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// 抽象处理者类
abstract class Approver {
    protected Approver nextApprover;
    protected String roleName;
    protected List<String> users;

    public Approver(String roleName, List<String> users) {
        this.roleName = roleName;
        this.users = users;
    }

    public void setNextApprover(Approver nextApprover) {
        this.nextApprover = nextApprover;
    }

    public abstract void handleRequest(double value);
}

// 动态处理者类（支持金额或天数）
class DynamicApprover extends Approver {
    private double maxLimit;

    public DynamicApprover(String roleName, double maxLimit, List<String> users) {
        super(roleName, users);
        this.maxLimit = maxLimit;
    }

    @Override
    public void handleRequest(double value) {
        if ((maxLimit < 0) || (value > 0 && value <= maxLimit)) {
            String user = getRandomUser();
            System.out.println(user + "（" + roleName + "）审批了值为：" + value);
        } else if (nextApprover != null) {
            nextApprover.handleRequest(value);
        } else {
            System.out.println("值 " + value + " 超出审批范围，无法处理");
        }
    }

    private String getRandomUser() {
        Random random = new Random();
        return users.get(random.nextInt(users.size()));
    }
}
// 主要类
public class version06 {
    public static void main(String[] args) throws Exception {
        // 加载配置文件
        String projectType = "leave"; // 可切换为 "leave"
        String fileName = "src/Chain_of_Responsibility/"+projectType + ".xml";
        List<Approver> approvers = loadConfiguration(fileName);

        // 动态组装职责链
        for (int i = 0; i < approvers.size() - 1; i++) {
            approvers.get(i).setNextApprover(approvers.get(i + 1));
        }

        // 从链头开始处理
        Approver chainHead = approvers.get(0);

        // 测试不同值
        double[] testValues = projectType.equals("procurement")
                ? new double[]{2000, 6000, 9000, 15000, 40000, -500}
                : new double[]{2, 5, 10, 40, -1};

        System.out.println("审批系统启动 - 项目：" + projectType);
        for (double value : testValues) {
            System.out.println("处理值：" + value);
            chainHead.handleRequest(value);
            System.out.println("---------------------------");
        }
    }

    // 加载配置文件
    public static List<Approver> loadConfiguration(String fileName) throws Exception {
        List<Approver> approvers = new ArrayList<>();
        File file = new File(fileName);

        // 使用 DOM 解析 XML 文件
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);
        document.getDocumentElement().normalize();

        NodeList ruleNodes = document.getElementsByTagName("rule");

        for (int i = 0; i < ruleNodes.getLength(); i++) {
            Node ruleNode = ruleNodes.item(i);
            if (ruleNode.getNodeType() == Node.ELEMENT_NODE) {
                Element ruleElement = (Element) ruleNode;

                // 读取角色
                String role = getTextContent(ruleElement, "role");

                // 读取最大值
                double maxLimit = -1; // 默认值为无限制
                if (ruleElement.getElementsByTagName("maxAmount").getLength() > 0) {
                    maxLimit = Double.parseDouble(getTextContent(ruleElement, "maxAmount"));
                } else if (ruleElement.getElementsByTagName("maxDays").getLength() > 0) {
                    maxLimit = Double.parseDouble(getTextContent(ruleElement, "maxDays"));
                }

                // 读取用户列表
                List<String> users = new ArrayList<>();
                NodeList userNodes = ruleElement.getElementsByTagName("user");
                for (int j = 0; j < userNodes.getLength(); j++) {
                    users.add(userNodes.item(j).getTextContent());
                }

                approvers.add(new DynamicApprover(role, maxLimit, users));
            }
        }
        return approvers;
    }

    // 辅助方法：安全获取节点文本内容
    private static String getTextContent(Element element, String tagName) {
        NodeList nodeList = element.getElementsByTagName(tagName);
        if (nodeList.getLength() > 0 && nodeList.item(0) != null) {
            return nodeList.item(0).getTextContent();
        }
        return "";
    }

}
