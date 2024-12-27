package boardscreen;

public class EditCommand implements Command {
    private BoardScreen screen;
    public EditCommand(BoardScreen screen){
        this.screen = screen;
    }

    @Override
    public void execute() {
        screen.edit();
    }
}
