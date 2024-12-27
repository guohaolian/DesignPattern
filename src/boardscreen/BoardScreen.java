package boardscreen;

public class BoardScreen {
    private Menu menu;
    private MenuItem openItem,createItem,editItem;
    public BoardScreen(){
        menu=new Menu();
        openItem=new MenuItem("��");
        createItem=new MenuItem("�½�");
        editItem=new MenuItem("�༭");
        menu.addMenuItem(openItem);
        menu.addMenuItem(createItem);
        menu.addMenuItem(editItem);
    }
    public void display(){
        System.out.println("���˵�ѡ��:");
        for (MenuItem menuItem : menu.itemList) {
            System.out.println(menuItem.getName());
        }
    }

    public void open(){
        System.out.println("��ʾ�򿪴��ڣ�");
    }
    public void create(){
        System.out.println("��ʾ�½����ڣ�");
    }
    public void edit(){
        System.out.println("��ʾ�༭���ڣ�");
    }
    public Menu getMenu(){
        return menu;
    }

}
