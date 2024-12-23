package biAdapter;

public class Adapter implements Cat, Dog {
    private Dog dog;
    private Cat cat;
    public Adapter() {
        this.dog = new ConcreteDog();
        this.cat = new ConcreteCat();
    }


    @Override
    public void cry() {
        System.out.print("√®—ßπ∑Ω–£∫");
        dog.bark();
    }

    @Override
    public void catchMouse() {
        cat.catchMouse();
    }

    @Override
    public void bark() {
        System.out.print("π∑—ß√®Ω–£∫");
        cat.cry();
    }

    @Override
    public void action() {
        System.out.print("π∑—ß√®◊•¿œ Û£∫");
        cat.catchMouse();
    }
}
