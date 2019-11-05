package maze;

public class MazeGenerator {

    public static Maze generateMaze(int size) {
        int[][] cells = new int[size][size];

        cells = initCells(cells);

        return new Maze(cells);
    }

    private static int[][] initCells(int[][] cells) {
        for(int i=0; i<cells.length; i++) {
            for(int j=0; j<cells[0].length; j++) {
                cells[i][j] = 1;
            }
        }

        return cells;
    }

}
