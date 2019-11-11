package maze.menu;

import maze.MazeRunner;

public class ExitMenuItem implements MenuItem {

    private MazeRunner program;

    public ExitMenuItem(MazeRunner mazeRunner) {
        this.program = mazeRunner;
    }

    @Override
    public void execute() {
        this.program.end();
    }

    @Override
    public String toString() {
        return "Exit.";
    }
}
