package shortcutproxy;

public class Picture implements Subject{
    private Application app=new Application();

    @Override
    public void run() {
        System.out.println("��ݷ�ʽ�����������");
        app.run();
    }
}
