package WhiteBlack;

public class Whitechess implements AbstractChessman {
    private String chess;
    private int x;
    private int y;

    @Override
    public void setchess(String chess) {
        this.chess = chess;
    }

    @Override
    public void point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void show() {
        System.out.println(this.chess + "(" + this.x + "," + this.y + ")");

    }


}
