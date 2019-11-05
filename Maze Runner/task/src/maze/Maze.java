package maze;

public class Maze {

    private int[][] mazeCells;

    public Maze(int[][] cells) {
        this.mazeCells = cells;
    }

    public void printMaze() {
        for(int i=0; i<mazeCells.length; i++) {
            for(int j=0; j<mazeCells[0].length; j++) {
                if(mazeCells[i][j] == 0) {
                    System.out.print("  ");
                } else if(mazeCells[i][j] == 1) {
                    System.out.print("\u2588\u2588");
                }
            }
            System.out.print("\n");
        }
    }

}
