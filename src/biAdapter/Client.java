package biAdapter;

public class Client {
    public static void main(String[] args) {
        Adapter adapter = new Adapter();
        Cat cat=(Cat)adapter;
        Dog dog=(Dog)adapter;
        cat.cry();
        cat.catchMouse();
        dog.bark();
        dog.action();

    }
}
