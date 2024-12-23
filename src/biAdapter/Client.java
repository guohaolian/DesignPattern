package biAdapter;

public class Client {
    public static void main(String[] args) {
        Adapter adapter = new Adapter();
        adapter.cry();
        adapter.catchMouse();
        adapter.bark();
        adapter.action();
    }
}
