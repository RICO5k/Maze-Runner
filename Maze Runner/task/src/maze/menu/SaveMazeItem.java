package maze.menu;

import maze.FileOperations;
import maze.Maze;
import maze.MazeRunner;

import java.util.List;
import java.util.Scanner;

public class SaveMazeItem implements MenuItem {

    private MazeRunner program;
    private Scanner scanner;

    public SaveMazeItem(MazeRunner mazeRunner) {
        this.program = mazeRunner;
        this.scanner = mazeRunner.getScanner();
    }

    @Override
    public void execute() {
        String fileName = scanner.nextLine();
        Maze maze = this.program.getMaze();
        List<String> mazeList = maze.getMazeList();
        FileOperations.saveListToFile(mazeList, fileName);
    }

    @Override
    public String toString() {
        return "Save the maze.";
    }
}
