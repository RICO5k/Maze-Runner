package maze.menu;

import maze.MazeRunner;
import maze.MazeSolver;

public class FindEscapeItem implements MenuItem {

    private MazeRunner program;

    public FindEscapeItem(MazeRunner mazeRunner) {
        this.program = mazeRunner;
    }

    @Override
    public void execute() {
        this.program.setMaze( MazeSolver.solveMaze( this.program.getMaze() ) );
        this.program.getMaze().printMaze();
    }

    @Override
    public String toString() {
        return "find the escape.";
    }
}
