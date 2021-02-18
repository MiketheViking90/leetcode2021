package algo;

public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        int maxArea = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    int area = exploreIsland(grid, i, j);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }

    private int exploreIsland(int[][] grid, int i, int j) {
        int r = grid.length;
        int c = grid[0].length;

        if (i < 0 || i >= r) {
            return 0;
        }
        if (j < 0 || j >= c) {
            return 0;
        }

        if (grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = -1;
        return 1 + exploreIsland(grid, i-1, j) + exploreIsland(grid, i+1, j) + exploreIsland(grid, i, j-1) +
                exploreIsland(grid, i, j+1);
    }
}
