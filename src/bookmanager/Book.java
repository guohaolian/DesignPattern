package bookmanager;

public class Book implements iBook{
    @Override
    public void borrowBook() {
        System.out.println("���飡������");
    }

    @Override
    public void returnBook() {
        System.out.println("���飡������");
    }
}
