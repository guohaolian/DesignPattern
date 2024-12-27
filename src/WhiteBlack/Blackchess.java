package WhiteBlack;

public class Blackchess implements AbstractChessman{
    private String chess;
    private  int x;
    private  int y;

    public Blackchess(){
        System.out.println("--BlackChessman Construction Exec!!!");
    }

    @Override
    public void setchess(String chess) {
        this.chess = chess;
    }

    @Override
    public void point(int x, int y) {
        this.x=x;
        this.y=y;
        show();

    }

    @Override
    public void show() {
        System.out.println(this.chess + "(" + this.x + "," + this.y + ")");

    }
}
