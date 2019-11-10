package maze;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class MazeGenerator {

    private static int[][] mazeCells;

    public static Maze generateMaze(int size) {
        mazeCells = new int[size][size];

         initCells();

         //Generate path
        createPath(1, 1);

         //Entrance
        setAsPath(1, 0);

        //Exit
        setAsPath(size-2, size-1);

        return new Maze(mazeCells);
    }

    private static void initCells() {
        for(int i=0; i<mazeCells.length; i++) {
            for(int j=0; j<mazeCells[0].length; j++) {
                mazeCells[i][j] = 1;
            }
        }
    }

    private static void createPath(int x, int y) {
        setAsPath(x, y);
        List<Directions> directions = getShuffledPossibleDirection(x, y);
            for(Directions direction : directions) {
                if(isPossibleDirection(direction, x, y))
                    createPath(x + direction.getNextX(), y + direction.getNextY());
            }
    }

    private static void setAsPath(int x, int y) {
        mazeCells[x][y] = 0;
    }

    private static List<Directions> getShuffledPossibleDirection(int x, int y) {
        List<Directions> directions = new ArrayList<>();

        for(Directions direction : Directions.values()) {
            if(isPossibleDirection(direction, x, y)) {
                directions.add(direction);
            }
        }

        Collections.shuffle(directions);
        return directions;
    }

    private static boolean isPossibleDirection(Directions direction, int x, int y) {
        switch(direction) {
            case NORTH: return checkNorth(x, y);
            case EAST: return checkEast(x, y);
            case SOUTH: return checkSouth(x, y);
            case WEST: return checkWest(x, y);
            default: throw new IllegalArgumentException();
        }
    }

    private static boolean checkNorth(int x, int y) {
        int xStart = x-2;
        int xEnd = x-1;
        int yStart = y-1;
        int yEnd = y+1;

        if(xStart < 0 || xEnd >= mazeCells[0].length || yStart < 0 || yEnd >= mazeCells.length) {
            return false;
        }

        for (int i = xStart; i <= xEnd; i++) {
            for (int j = yStart; j <= yEnd; j++) {
                if(mazeCells[i][j] == 0) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean checkEast(int x, int y) {
        int xStart = x-1;
        int xEnd = x+1;
        int yStart = y+1;
        int yEnd = y+2;

        if(xStart < 0 || xEnd >= mazeCells[0].length || yStart < 0 || yEnd >= mazeCells.length) {
            return false;
        }

        for (int i = xStart; i <= xEnd; i++) {
            for (int j = yStart; j <= yEnd; j++) {
                if(mazeCells[i][j] == 0) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean checkSouth(int x, int y) {
        int xStart = x+1;
        int xEnd = x+2;
        int yStart = y-1;
        int yEnd = y+1;

        if(xStart < 0 || xEnd >= mazeCells[0].length || yStart < 0 || yEnd >= mazeCells.length) {
            return false;
        }

        for (int i = xStart; i <= xEnd; i++) {
            for (int j = yStart; j <= yEnd; j++) {
                if(mazeCells[i][j] == 0) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean checkWest(int x, int y) {
        int xStart = x-1;
        int xEnd = x+1;
        int yStart = y-2;
        int yEnd = y-1;

        if(xStart < 0 || xEnd >= mazeCells[0].length || yStart < 0 || yEnd >= mazeCells.length) {
            return false;
        }

        for (int i = xStart; i <= xEnd; i++) {
            for (int j = yStart; j <= yEnd; j++) {
                if(mazeCells[i][j] == 0) {
                    return false;
                }
            }
        }

        return true;
    }
}
