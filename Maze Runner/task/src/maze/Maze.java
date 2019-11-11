package maze;

import java.util.ArrayList;
import java.util.List;

public class Maze {

    private int[][] mazeCells;

    public Maze(int[][] cells) {
        this.mazeCells = cells;
    }

    public Maze(List<String> mazeList) {
        int rows = mazeList.size();
        int columns = mazeList.get(0).length()/2;

        this.mazeCells = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            String mazeLine = mazeList.get(i);
            for (int j = 0; j < columns; j++) {
                char sign = mazeLine.charAt(j*2);
                if(sign == '\u2588')
                    this.mazeCells[i][j] = 1;
                else if(sign == ' ') {
                    this.mazeCells[i][j] = 0;
                }
            }
        }
    }

    public List<String> getMazeList() {
        List<String> mazeList = new ArrayList<>();

        for(int i=0; i<mazeCells.length; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<mazeCells[0].length; j++) {
                if(mazeCells[i][j] == 0) {
                    sb.append("  ");
                } else if(mazeCells[i][j] == 1) {
                    sb.append("\u2588\u2588");
                }
            }
            mazeList.add(sb.toString());
        }

        return mazeList;
    }

    public void printMaze() {
        List<String> mazeList = getMazeList();

        for(String mazeLine : mazeList) {
            System.out.println(mazeLine);
        }
    }

}
