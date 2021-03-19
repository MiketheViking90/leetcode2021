package algo;

public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int r = board.length;
        int c = board[0].length;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int val = board[i][j];
                int liveNeighbors = getLiveNeighbors(i, j, board);

                if (val == 1) {
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        board[i][j] = -1;
                    }
                } else {
                    if (liveNeighbors == 3) {
                        board[i][j] = 2;
                    }
                }
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int val = board[i][j];
                if (val == -1) {
                    board[i][j] = 0;
                } else if (val == 2) {
                    board[i][j] = 1;
                }
            }
        }
    }

    private int getLiveNeighbors(int x, int y, int[][] board) {
        int r = board.length;
        int c = board[0].length;
        int sum = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int x1 = x+i;
                int y1 = y+i;
                if (x1 >= 0 && x1 < r && y1 >= 0 && y1<c) {
                    if (board[x1][y1] == 1 || board[x1][y1] == -1) {
                        sum++;
                    }
                }
            }
        }

        return sum;
    }
}
