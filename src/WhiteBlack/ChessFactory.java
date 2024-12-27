package WhiteBlack;

import java.util.ArrayList;

public class ChessFactory {
    private ArrayList chessList =new ArrayList();

    private static ChessFactory instance = null;

    private ChessFactory() {
    }

    public static ChessFactory getInstance() {
        if (instance == null) {
            instance = new ChessFactory();
        }
        return instance;
    }

    public void createChessman(String chessmanName) {
        AbstractChessman chessman1 = new Blackchess();
        chessman1.setchess("BlackChess");
        chessList.add(chessman1);
        AbstractChessman chessman2 = new Whitechess();
        chessman2.setchess("WhiteChess");
        chessList.add(chessman2);

    }

    public AbstractChessman getChess(String chessman){
        if(chessman.equals("BlackChess")){
            return (AbstractChessman)chessList.get(0);
        }
        else if(chessman.equals("WhiteChess")){
            return (AbstractChessman)chessList.get(1);
        }
        return null;
    }

}
