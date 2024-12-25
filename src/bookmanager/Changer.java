package bookmanager;

public class Changer implements iBook{
    private iBook book;
    public Changer(iBook book) {
        this.book = book;
    }

    @Override
    public void borrowBook() {
        book.borrowBook();
    }

    @Override
    public void returnBook() {
        book.returnBook();
    }
}
