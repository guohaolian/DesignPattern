package Chain_of_Responsibility;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// 抽象处理者类
abstract class Approver05 {
    protected Approver05 nextApprover; // 下一个处理者
    protected double maxAmount; // 最大审批额度
    protected String roleName; // 职务名称
    protected List<String> users; // 用户列表

    public Approver05(String roleName, double maxAmount, List<String> users) {
        this.roleName = roleName;
        this.maxAmount = maxAmount;
        this.users = users;
    }

    public void setNextApprover(Approver05 nextApprover) {
        this.nextApprover = nextApprover;
    }

    // 抽象方法：处理请求
    public void handleRequest(double amount) {
        if (amount > 0 && amount <= maxAmount) {
            String user = getRandomUser(); // 获取某位具体用户审批
            System.out.println(user + "（" + roleName + "）审批了采购金额：" + amount + "元");
        } else if (nextApprover != null) {
            nextApprover.handleRequest(amount);
        } else {
            System.out.println("金额 " + amount + " 超出审批范围，无法处理");
        }
    }

    // 随机获取一个具体用户
    protected String getRandomUser() {
        Random random = new Random();
        return users.get(random.nextInt(users.size()));
    }
}

// 动态处理者类
class DynamicApprover05 extends Approver05 {
    public DynamicApprover05(String roleName, double maxAmount, List<String> users) {
        super(roleName, maxAmount, users);
    }
}

// 测试类
public class version05 {
    public static void main(String[] args) {
        // 动态创建审批规则：责任者、额度范围及用户列表
        List<Approver05> approvers = new ArrayList<>();
        approvers.add(new DynamicApprover05("教学主任", 5000, List.of("张三", "李四")));
        approvers.add(new DynamicApprover05("副院长", 8000, List.of("王五")));
        approvers.add(new DynamicApprover05("院长", 10000, List.of("赵六", "孙七")));
        approvers.add(new DynamicApprover05("副校长", 30000, List.of("周八")));
        approvers.add(new DynamicApprover05("校长", Double.MAX_VALUE, List.of("吴九")));

        // 动态组装职责链
        for (int i = 0; i < approvers.size() - 1; i++) {
            approvers.get(i).setNextApprover(approvers.get(i + 1));
        }

        // 从链头开始处理
        Approver05 chainHead = approvers.get(0);

        // 测试不同金额的采购
        double[] testAmounts = {2000, 6000, 9000, 15000, 40000, -500};

        System.out.println("采购审批系统启动");
        for (double amount : testAmounts) {
            System.out.println("处理采购金额: " + amount + "元");
            chainHead.handleRequest(amount);
            System.out.println("---------------------------");
        }
    }
}
