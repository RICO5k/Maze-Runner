package maze;

public class MazeRunner {

    private final int MAZE_SIZE = 10;

    public MazeRunner(){};

    public void run() {
        Maze maze = MazeGenerator.generateMaze(MAZE_SIZE);
        maze.printMaze();
    }
}
