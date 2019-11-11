package maze.menu;

import maze.Maze;
import maze.MazeRunner;

public class DisplayMazeItem implements MenuItem {

    private MazeRunner program;

    public DisplayMazeItem(MazeRunner mazeRunner) {
        this.program = mazeRunner;
    }

    @Override
    public void execute() {
        program.getMaze().printMaze();
    }

    @Override
    public String toString() {
        return "Display the maze.";
    }
}
