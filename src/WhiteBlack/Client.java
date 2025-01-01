package WhiteBlack;

import java.util.Random;
//享元模式
public class Client {
    public static void main(String[] args) {
        AbstractChessman chess=null;
        Random random = new Random();
        int radom = 0;
        ChessFactory fivechessfactory=ChessFactory.getInstance();

        // 随机获得棋子
        for (int i = 0; i < 10; i++) {
            radom = random.nextInt(2);
            switch (radom) {
                // 获得黑棋
                case 0:
                    chess = fivechessfactory.getChess("Black");
                    break;
                // 获得白棋
                case 1:
                    chess = fivechessfactory.getChess("White");
                    break;
            }
            if (chess != null) {
                chess.point(i, random.nextInt(15));
            }
        }
       /* chess1=fivechessfactory.getChess("White");
        chess2=fivechessfactory.getChess("Black");
        chess3=fivechessfactory.getChess("White");
        chess4=fivechessfactory.getChess("Black");
        chess5=fivechessfactory.getChess("White");
        chess6=fivechessfactory.getChess("Black");
        chess1.point(1,2);
        chess2.point(3,4);
        chess3.point(5,6);
        chess4.point(7,8);
        chess5.point(9,10);
        chess6.point(11,12);*/
    }
}
