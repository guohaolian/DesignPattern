package bookmanager;

public class NewBook extends Changer{
    public NewBook(iBook book) {
        super(book);
    }
    public  void freeze(){
        System.out.println("�����鼮������");
    }
    public void lose(){
        System.out.println("��ʧ�鼮������");
    }
}
