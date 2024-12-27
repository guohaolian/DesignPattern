package boardscreen;

import java.util.ArrayList;

public class Menu {
    public ArrayList<MenuItem> itemList = new ArrayList<>();
    public void addMenuItem(MenuItem item){
        itemList.add(item);
    }
}
