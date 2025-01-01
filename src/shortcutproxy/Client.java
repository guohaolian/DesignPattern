package shortcutproxy;
//代理模式
//客户端测试类
public class Client {
    public static void main(String[] args) {
        // 使用多态创建一个subject对象
        Subject client = new Picture();
        // 调用subject对象的run方法，实际上是application的run方法在运行
        client.run();
    }
}
