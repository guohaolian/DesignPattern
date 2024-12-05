package Chain_of_Responsibility;

public class version01 {
    // 方法根据采购金额决定审批人
    public static String getApprover(double amount) {
        if (amount > 0 && amount <= 5000) {
            return "教学主任";
        } else if (amount > 5000 && amount <= 10000) {
            return "院长";
        } else if (amount > 10000 && amount <= 30000) {
            return "副校长";
        } else if (amount > 30000) {
            return "校长";
        } else {
            return "金额无效，无法审批";
        }
    }

    public static void main(String[] args) {
        // 示例数据，测试程序逻辑
        double[] testAmounts = {2000, 7000, 15000, 40000, -500};

        System.out.println("采购审批系统");
        for (double amount : testAmounts) {
            System.out.println("采购金额: " + amount + "元");
            String approver = getApprover(amount);
            System.out.println("审批人: " + approver);
            System.out.println("---------------------------");
        }
    }
}
