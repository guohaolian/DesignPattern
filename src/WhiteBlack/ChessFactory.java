package WhiteBlack;

import java.util.ArrayList;

public class ChessFactory {
    private ArrayList chessList =new ArrayList();

    private static ChessFactory instance = null;

    private ChessFactory() {
        AbstractChessman chessman1 = new Blackchess();
        chessman1.setchess("BlackChess");
        chessList.add(chessman1);
        AbstractChessman chessman2 = new Whitechess();
        chessman2.setchess("WhiteChess");
        chessList.add(chessman2);
    }

    public static ChessFactory getInstance() {
        if (instance == null) {
            instance = new ChessFactory();
        }
        return instance;
    }

    public AbstractChessman getChess(String chessman){
        if(chessman.equals("Black")){
            return (AbstractChessman)chessList.get(0);
        }
        else if(chessman.equals("White")){
            return (AbstractChessman)chessList.get(1);
        }
        return null;
    }

}
