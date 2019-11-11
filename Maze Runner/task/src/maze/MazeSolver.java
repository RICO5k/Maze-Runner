package maze;

import java.util.ArrayList;
import java.util.List;

public class MazeSolver {

    private static int[][] mazeCells;
    private static int[][] mazeCellsCopy;

    private static int entranceX;
    private static int entranceY;

    private static int exitX;
    private static int exitY;

    private static List<Integer[]> path = new ArrayList<>();

    public static Maze solveMaze(Maze maze) {
        mazeCells = maze.getMazeCellsCopy();
        mazeCellsCopy = maze.getMazeCellsCopy();

        findEntrance();
        findExit();

        findPath(entranceX, entranceY);

        markPath();

        return new Maze(mazeCells);
    }

    private static void findEntrance() {
        //Check left and right wall
        int leftWallIndex = 0;
        int rightWallIndex = mazeCells[0].length-1;

        for(int i=0; i<mazeCells.length; i++) {
            if(mazeCells[i][leftWallIndex] == 0) {
                entranceX = i;
                entranceY = leftWallIndex;
                return;
            } else if(mazeCells[i][rightWallIndex] == 0) {
                entranceX = i;
                entranceY = rightWallIndex;
                return;
            }
        }

        // Check top and bottom wall
        int topWallIndex = 0;
        int bottomWallIndex = mazeCells.length-1;

        for(int i=0; i<mazeCells[0].length; i++) {
            if(mazeCells[topWallIndex][i] == 0) {
                entranceX = topWallIndex;
                entranceY = i;
                return;
            } else if(mazeCells[bottomWallIndex][i] == 0) {
                entranceX = topWallIndex;
                entranceY = i;
                return;
            }
        }
    }

    private static void findExit() {
        //Check left and right wall
        int leftWallIndex = 0;
        int rightWallIndex = mazeCells[0].length-1;

        for(int i=0; i<mazeCells.length; i++) {
            if(mazeCells[i][leftWallIndex] == 0 && (i != entranceX || leftWallIndex != entranceY)) {
                exitX = i;
                exitY = leftWallIndex;
                return;
            } else if(mazeCells[i][rightWallIndex] == 0 && (i != entranceX || rightWallIndex != entranceY)) {
                exitX = i;
                exitY = rightWallIndex;
                return;
            }
        }

        // Check top and bottom wall
        int topWallIndex = 0;
        int bottomWallIndex = mazeCells.length-1;

        for(int i=0; i<mazeCells[0].length; i++) {
            if(mazeCells[topWallIndex][i] == 0 && (topWallIndex != exitX || i != exitY)) {
                exitX = topWallIndex;
                exitY = i;
                return;
            } else if(mazeCells[bottomWallIndex][i] == 0 && (bottomWallIndex != exitX || i != exitY)) {
                exitX = topWallIndex;
                exitY = i;
                return;
            }
        }
    }

    private static boolean findPath(int x, int y) {
        path.add(new Integer[]{x, y});

        if(x == exitX && y == exitY) {
            return true;
        }

        for(Directions direction : Directions.values()) {
            int nextX = x+direction.getNextX();
            int nextY = y+direction.getNextY();
            if(path.size() > 1) {
                Integer[] a = path.get(path.size()-2);
                if(nextX == a[0] && nextY == a[1]) {
                    continue;
                }
            }
            if(mazeCellsCopy[nextX][nextY] == 1) {
                continue;
            }
            boolean found = findPath(nextX, nextY);
            if(found) {
                return true;
            }
        }

        path.remove(path.size()-1);
        mazeCellsCopy[x][y] = 1;
        return false;
    }

    private static void markPath() {
        for(Integer[] cellCords : path) {
            mazeCells[cellCords[0]][cellCords[1]] = 2;
        }
    }

}
