package boardscreen;
//命令模式
public class Client {
    public static void main(String[] args) {
        BoardScreen screen = new BoardScreen();//接收者
        Menu menu=screen.getMenu();
        Command openCommand,createCommand,editCommand;//命令
        openCommand=new OpenCommand(screen);
        createCommand=new CreateCommand(screen);
        editCommand=new EditCommand(screen);
        MenuItem openItem,createItem,editItem;//调用者
        openItem=menu.itemList.get(0);
        createItem=menu.itemList.get(1);
        editItem=menu.itemList.get(2);
        openItem.setCommand(openCommand);
        createItem.setCommand(createCommand);
        editItem.setCommand(editCommand);
        screen.display();
        openItem.click();
        createItem.click();
        editItem.click();
    }
}
