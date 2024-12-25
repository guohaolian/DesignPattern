package bookmanager;

public class Client {
    public static void main(String[] args) {
        iBook book;
        book=new Book();
        book.borrowBook();
        book.returnBook();
        System.out.println("------------------------");

        NewBook newBook=new NewBook(book);
        newBook.borrowBook();
        newBook.freeze();
        newBook.returnBook();
        newBook.lose();
    }
}
