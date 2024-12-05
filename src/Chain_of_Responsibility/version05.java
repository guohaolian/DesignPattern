package Chain_of_Responsibility;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// ����������
abstract class Approver05 {
    protected Approver05 nextApprover; // ��һ��������
    protected double maxAmount; // ����������
    protected String roleName; // ְ������
    protected List<String> users; // �û��б�

    public Approver05(String roleName, double maxAmount, List<String> users) {
        this.roleName = roleName;
        this.maxAmount = maxAmount;
        this.users = users;
    }

    public void setNextApprover(Approver05 nextApprover) {
        this.nextApprover = nextApprover;
    }

    // ���󷽷�����������
    public void handleRequest(double amount) {
        if (amount > 0 && amount <= maxAmount) {
            String user = getRandomUser(); // ��ȡĳλ�����û�����
            System.out.println(user + "��" + roleName + "�������˲ɹ���" + amount + "Ԫ");
        } else if (nextApprover != null) {
            nextApprover.handleRequest(amount);
        } else {
            System.out.println("��� " + amount + " ����������Χ���޷�����");
        }
    }

    // �����ȡһ�������û�
    protected String getRandomUser() {
        Random random = new Random();
        return users.get(random.nextInt(users.size()));
    }
}

// ��̬��������
class DynamicApprover05 extends Approver05 {
    public DynamicApprover05(String roleName, double maxAmount, List<String> users) {
        super(roleName, maxAmount, users);
    }
}

// ������
public class version05 {
    public static void main(String[] args) {
        // ��̬�����������������ߡ���ȷ�Χ���û��б�
        List<Approver05> approvers = new ArrayList<>();
        approvers.add(new DynamicApprover05("��ѧ����", 5000, List.of("����", "����")));
        approvers.add(new DynamicApprover05("��Ժ��", 8000, List.of("����")));
        approvers.add(new DynamicApprover05("Ժ��", 10000, List.of("����", "����")));
        approvers.add(new DynamicApprover05("��У��", 30000, List.of("�ܰ�")));
        approvers.add(new DynamicApprover05("У��", Double.MAX_VALUE, List.of("���")));

        // ��̬��װְ����
        for (int i = 0; i < approvers.size() - 1; i++) {
            approvers.get(i).setNextApprover(approvers.get(i + 1));
        }

        // ����ͷ��ʼ����
        Approver05 chainHead = approvers.get(0);

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
