package Chain_of_Responsibility;

public class version01 {
    // �������ݲɹ�������������
    public static String getApprover(double amount) {
        if (amount > 0 && amount <= 5000) {
            return "��ѧ����";
        } else if (amount > 5000 && amount <= 10000) {
            return "Ժ��";
        } else if (amount > 10000 && amount <= 30000) {
            return "��У��";
        } else if (amount > 30000) {
            return "У��";
        } else {
            return "�����Ч���޷�����";
        }
    }

    public static void main(String[] args) {
        // ʾ�����ݣ����Գ����߼�
        double[] testAmounts = {2000, 7000, 15000, 40000, -500};

        System.out.println("�ɹ�����ϵͳ");
        for (double amount : testAmounts) {
            System.out.println("�ɹ����: " + amount + "Ԫ");
            String approver = getApprover(amount);
            System.out.println("������: " + approver);
            System.out.println("---------------------------");
        }
    }
}
