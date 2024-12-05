package Chain_of_Responsibility;

import java.util.ArrayList;
import java.util.List;

// ����������
abstract class Approver04 {
    protected Approver04 nextApprover; // ��һ��������
    protected double maxAmount; // ����������
    protected String name; // ����������

    public Approver04(String name, double maxAmount) {
        this.name = name;
        this.maxAmount = maxAmount;
    }

    public void setNextApprover(Approver04 nextApprover) {
        this.nextApprover = nextApprover;
    }

    // ���󷽷�����������
    public void handleRequest(double amount) {
        if (amount > 0 && amount <= maxAmount) {
            System.out.println(name + " �����˲ɹ���" + amount + "Ԫ");
        } else if (nextApprover != null) {
            nextApprover.handleRequest(amount);
        } else {
            System.out.println("��� " + amount + " ����������Χ���޷�����");
        }
    }
}

// ��̬��������
class DynamicApprover04 extends Approver04 {
    public DynamicApprover04(String name, double maxAmount) {
        super(name, maxAmount);
    }
}

// ������
public class version04 {
    public static void main(String[] args) {
        // ��̬�����������������ߺͶ�ȷ�Χ
        List<Approver04> approvers = new ArrayList<>();
        approvers.add(new DynamicApprover04("��ѧ����", 5000));
        approvers.add(new DynamicApprover04("��Ժ��", 8000));
        approvers.add(new DynamicApprover04("Ժ��", 10000));
        approvers.add(new DynamicApprover04("��У��", 30000));
        approvers.add(new DynamicApprover04("У��", Double.MAX_VALUE)); // ���޴��ʾ�����

        // ��̬��װְ����
        for (int i = 0; i < approvers.size() - 1; i++) {
            approvers.get(i).setNextApprover(approvers.get(i + 1));
        }

        // ����ͷ��ʼ����
        Approver04 chainHead = approvers.get(0);

        // ���Բ�ͬ���Ĳɹ�
        double[] testAmounts = {2000, 6000, 9000, 15000, 40000, -500};

        System.out.println("�ɹ�����ϵͳ����");
        for (double amount : testAmounts) {
            System.out.println("����ɹ����: " + amount + "Ԫ");
            chainHead.handleRequest(amount);
            System.out.println("---------------------------");
        }
    }
}
