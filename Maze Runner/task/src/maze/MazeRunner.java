package maze;

import java.util.Scanner;

public class MazeRunner {

    private Scanner scanner;

    public MazeRunner(Scanner scanner){
        this.scanner = scanner;
    };

    public void run() {
        System.out.println("Please, enter the sie of a maze");

        int rows = scanner.nextInt();
        int columns = scanner.nextInt();

        Maze maze = MazeGenerator.generateMaze(rows, columns);
        maze.printMaze();
    }
}
