package maze;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MazeRunner mazeRunner = new MazeRunner(new Scanner(System.in));
        mazeRunner.run();
    }
}
