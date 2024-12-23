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
        System.out.print("èѧ���У�");
        dog.bark();
    }

    @Override
    public void catchMouse() {
        cat.catchMouse();
    }

    @Override
    public void bark() {
        System.out.print("��ѧè�У�");
        cat.cry();
    }

    @Override
    public void action() {
        System.out.print("��ѧèץ����");
        cat.catchMouse();
    }
}
