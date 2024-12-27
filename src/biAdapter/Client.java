package biAdapter;

public class Client {
    public static void main(String[] args) {
        Adapter adapter = new Adapter();
        Cat cat= adapter;
        Dog dog= adapter;
        cat.cry();
        cat.catchMouse();
        dog.bark();
        dog.action();

    }
}
