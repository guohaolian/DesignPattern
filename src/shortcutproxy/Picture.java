package shortcutproxy;

public class Picture implements Subject{
    private Application app=new Application();

    @Override
    public void run() {
        System.out.println("快捷方式被点击！！！");
        app.run();
    }
}
