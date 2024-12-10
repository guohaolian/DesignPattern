package Chain_of_Responsibility;

import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// ����������
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

// ��̬�������֧ࣨ�ֽ���������
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
            System.out.println(user + "��" + roleName + "��������ֵΪ��" + value);
        } else if (nextApprover != null) {
            nextApprover.handleRequest(value);
        } else {
            System.out.println("ֵ " + value + " ����������Χ���޷�����");
        }
    }

    private String getRandomUser() {
        Random random = new Random();
        return users.get(random.nextInt(users.size()));
    }
}
// ��Ҫ��
public class version06 {
    public static void main(String[] args) throws Exception {
        // ���������ļ�
        String projectType = "leave"; // ���л�Ϊ "leave"
        String fileName = "src/Chain_of_Responsibility/"+projectType + ".xml";
        List<Approver> approvers = loadConfiguration(fileName);

        // ��̬��װְ����
        for (int i = 0; i < approvers.size() - 1; i++) {
            approvers.get(i).setNextApprover(approvers.get(i + 1));
        }

        // ����ͷ��ʼ����
        Approver chainHead = approvers.get(0);

        // ���Բ�ֵͬ
        double[] testValues = projectType.equals("procurement")
                ? new double[]{2000, 6000, 9000, 15000, 40000, -500}
                : new double[]{2, 5, 10, 40, -1};

        System.out.println("����ϵͳ���� - ��Ŀ��" + projectType);
        for (double value : testValues) {
            System.out.println("����ֵ��" + value);
            chainHead.handleRequest(value);
            System.out.println("---------------------------");
        }
    }

    // ���������ļ�
    public static List<Approver> loadConfiguration(String fileName) throws Exception {
        List<Approver> approvers = new ArrayList<>();
        File file = new File(fileName);

        // ʹ�� DOM ���� XML �ļ�
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);
        document.getDocumentElement().normalize();

        NodeList ruleNodes = document.getElementsByTagName("rule");

        for (int i = 0; i < ruleNodes.getLength(); i++) {
            Node ruleNode = ruleNodes.item(i);
            if (ruleNode.getNodeType() == Node.ELEMENT_NODE) {
                Element ruleElement = (Element) ruleNode;

                // ��ȡ��ɫ
                String role = getTextContent(ruleElement, "role");

                // ��ȡ���ֵ
                double maxLimit = -1; // Ĭ��ֵΪ������
                if (ruleElement.getElementsByTagName("maxAmount").getLength() > 0) {
                    maxLimit = Double.parseDouble(getTextContent(ruleElement, "maxAmount"));
                } else if (ruleElement.getElementsByTagName("maxDays").getLength() > 0) {
                    maxLimit = Double.parseDouble(getTextContent(ruleElement, "maxDays"));
                }

                // ��ȡ�û��б�
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

    // ������������ȫ��ȡ�ڵ��ı�����
    private static String getTextContent(Element element, String tagName) {
        NodeList nodeList = element.getElementsByTagName(tagName);
        if (nodeList.getLength() > 0 && nodeList.item(0) != null) {
            return nodeList.item(0).getTextContent();
        }
        return "";
    }

}
