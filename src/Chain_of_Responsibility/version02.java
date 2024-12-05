package Chain_of_Responsibility;

import java.util.ArrayList;
import java.util.List;

// 抽象处理者类
abstract class Approver02 {
    protected Approver02 nextApprover; // 下一个处理者
    protected double maxAmount; // 最大审批额度
    protected String name; // 责任者名字

    public Approver02(String name, double maxAmount) {
        this.name = name;
        this.maxAmount = maxAmount;
    }

    public void setNextApprover(Approver02 nextApprover) {
        this.nextApprover = nextApprover;
    }

    // 抽象方法：处理请求
    public void handleRequest(double amount) {
        if (amount > 0 && amount <= maxAmount) {
            System.out.println(name + " 审批了采购金额：" + amount + "元");
        } else if (nextApprover != null) {
            nextApprover.handleRequest(amount);
        } else {
            System.out.println("金额 " + amount + " 超出审批范围，无法处理");
        }
    }
}

// 动态处理者类
class DynamicApprover02 extends Approver02 {
    public DynamicApprover02(String name, double maxAmount) {
        super(name, maxAmount);
    }
}

// 测试类
public class version02 {
    public static void main(String[] args) {
        // 动态创建审批规则：责任者和额度范围
        List<Approver02> approvers = new ArrayList<>();
        approvers.add(new DynamicApprover02("教学主任", 5000));
        approvers.add(new DynamicApprover02("院长", 10000));
        approvers.add(new DynamicApprover02("副校长", 30000));
        approvers.add(new DynamicApprover02("校长", Double.MAX_VALUE)); // 无限大表示最大额度

        // 动态组装职责链
        for (int i = 0; i < approvers.size() - 1; i++) {
            approvers.get(i).setNextApprover(approvers.get(i + 1));
        }

        // 从链头开始处理
        Approver02 chainHead = approvers.get(0);

        // 测试不同金额的采购
        double[] testAmounts = {2000, 7000, 15000, 40000, -500};

        System.out.println("采购审批系统启动");
        for (double amount : testAmounts) {
            System.out.println("处理采购金额: " + amount + "元");
            chainHead.handleRequest(amount);
            System.out.println("---------------------------");
        }
    }
}

