package algo;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        int count = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    exploreIsland(grid, i, j);
                }
            }
            
        }
        return count;
    }

    private void exploreIsland(char[][] grid, int i, int j) {
        int r = grid.length;
        int c = grid[0].length;

        boolean isInGrid = (i >= 0 && i < r) && (j >=0 && j < c);
        if (!isInGrid) {
            return;
        }

        if (grid[i][j] != '1') {
            return;
        }

        grid[i][j] = 'x';

        exploreIsland(grid, i-1, j);
        exploreIsland(grid, i+1, j);
        exploreIsland(grid, i, j-1);
        exploreIsland(grid, i, j+1);
    }

    public static void main(String[] args) {
        char[][] graph = {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        };
        int nIslands = new NumberOfIslands().numIslands(graph);
        System.out.println(nIslands);
    }
}
