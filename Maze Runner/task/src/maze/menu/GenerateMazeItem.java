package maze.menu;

import maze.MazeGenerator;
import maze.MazeRunner;

import java.util.Scanner;

public class GenerateMazeItem implements MenuItem {

    private MazeRunner program;
    private Scanner scanner;

    public GenerateMazeItem(MazeRunner mazeRunner) {
        this.program = mazeRunner;
        this.scanner = mazeRunner.getScanner();
    }

    @Override
    public void execute() {
        System.out.println("Enter the size of a new maze");
        int size = Integer.parseInt(scanner.nextLine());

        int rows = size;
        int columns = size;

        this.program.setMaze( MazeGenerator.generateMaze(rows, columns) );
        this.program.getMaze().printMaze();

        this.program.mazeHasBeenInitialized();
    }

    @Override
    public String toString() {
        return "Generate a new maze.";
    }
}
