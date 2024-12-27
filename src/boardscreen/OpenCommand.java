package boardscreen;

public class OpenCommand implements Command{
    private BoardScreen screen;
    public OpenCommand(BoardScreen screen){
        this.screen = screen;
    }

    @Override
    public void execute() {
        screen.open();
    }
}
