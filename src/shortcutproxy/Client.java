package shortcutproxy;
//����ģʽ
//�ͻ��˲�����
public class Client {
    public static void main(String[] args) {
        // ʹ�ö�̬����һ��subject����
        Subject client = new Picture();
        // ����subject�����run������ʵ������application��run����������
        client.run();
    }
}
