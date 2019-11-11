 package maze;

import maze.menu.*;

import java.util.Scanner;

public class MazeRunner {

    private Scanner scanner;

    private boolean running;
    private Menu menu;

    private Maze maze;

    public MazeRunner(Scanner scanner){
        this.scanner = scanner;
        this.running = true;
        this.maze = null;

        initializeNarrowMenu();
    };

    private void initializeNarrowMenu() {
        this.menu = new Menu();

        menu.addMenuItem("1", new GenerateMazeItem(this));
        menu.addMenuItem("2", new LoadMazeItem(this));
        menu.addMenuItem("0", new ExitMenuItem(this));
    }

    public void mazeHasBeenInitialized() {
        initializeFullMenu();
    }
    private void initializeFullMenu() {
        this.menu = new Menu();

        menu.addMenuItem("1", new GenerateMazeItem(this));
        menu.addMenuItem("2", new LoadMazeItem(this));
        menu.addMenuItem("3", new SaveMazeItem(this));
        menu.addMenuItem("4", new DisplayMazeItem(this));
        menu.addMenuItem("0", new ExitMenuItem(this));
    }

    public void run() {
        while(running) {
            menu.printMenu();
            String choice = getUserChoice();
            menu.executeMenuItem(choice);
        }
    }

    private String getUserChoice() {
        String choice = scanner.nextLine();

        while( !menu.hasMenuItem(choice) ) {
            System.out.println("Chosen option doesn't exist, please try again:");
            choice = scanner.nextLine();
        }

        return choice;
    }

    public void end() {
        System.out.println("Bye!");
        running = false;
    }

    public void setMaze(Maze maze) {
        this.maze = maze;
    }

    public Maze getMaze() {
        return this.maze;
    }

    public Scanner getScanner() {
        return this.scanner;
    }
}
