package boardscreen;

public class CreateCommand implements Command {
    private BoardScreen screen;
    public CreateCommand(BoardScreen screen){
        this.screen = screen;
    }

    @Override
    public void execute() {
        screen.create();
    }
}
