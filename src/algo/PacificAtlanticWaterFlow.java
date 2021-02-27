package algo;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        int r = matrix.length;
        if (r == 0) {
            return new ArrayList<>();
        }
        int c = matrix[0].length;

        int[][] pacific = new int[r][c];
        int[][] atlantic = new int[r][c];

        for (int i = 0; i < r; i++) {
            dfs(i, 0, pacific, matrix);
        }
        for (int i = 0; i < c; i++) {
            dfs(0, i, pacific, matrix);
        }


        for (int i = 0; i < r; i++) {
            dfs(i, c-1, atlantic, matrix);
        }
        for (int i = 0; i < c; i++) {
            dfs(r-1, i, atlantic, matrix);
        }

        List<List<Integer>> flow = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (pacific[i][j] == 1 && atlantic[i][j] == 1) {
                    List<Integer> coord = List.of(i, j);
                    flow.add(coord);
                }
            }
        }
        return flow;
    }

    private void dfs(int x, int y, int[][] mark, int[][] matrix) {
        mark[x][y] = 1;

        int r = matrix.length;
        int c = matrix[0].length;

        int level = matrix[x][y];
        if (x+1 < r && mark[x+1][y] == 0 && matrix[x+1][y] >= level) {
            dfs(x+1, y, mark, matrix);
        }

        if (x-1 >= 0 && mark[x-1][y] == 0 && matrix[x-1][y] >= level) {
            dfs(x-1, y, mark, matrix);
        }

        if (y+1 < c && mark[x][y+1] == 0 && matrix[x][y+1] >= level) {
            dfs(x, y+1, mark, matrix);
        }

        if (y-1 >= 0 && mark[x][y-1] == 0 && matrix[x][y-1] >= level) {
            dfs(x, y-1, mark, matrix);
        }
    }
}
