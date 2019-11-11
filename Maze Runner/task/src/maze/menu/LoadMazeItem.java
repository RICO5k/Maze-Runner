package maze.menu;

import maze.FileOperations;
import maze.Maze;
import maze.MazeRunner;

import java.util.List;
import java.util.Scanner;

public class LoadMazeItem implements MenuItem {

    private MazeRunner program;
    private Scanner scanner;

    public LoadMazeItem(MazeRunner mazeRunner) {
        this.program = mazeRunner;
        this.scanner = mazeRunner.getScanner();
    }

    @Override
    public void execute() {
        String fileName = scanner.nextLine();
        List<String> mazeList = FileOperations.readListFromFile(fileName);
        Maze maze = new Maze(mazeList);
        this.program.setMaze(maze);

        this.program.mazeHasBeenInitialized();
    }

    @Override
    public String toString() {
        return "Load a maze.";
    }
}
