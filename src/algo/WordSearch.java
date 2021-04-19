package algo;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return true;
        }

        int r = board.length;
        int c = board[0].length;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (dfs(board, word.toCharArray(), 0, i, j, new boolean[r][c])) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] word, int idx, int x, int y, boolean[][] seen) {
        if (idx == word.length) {
            return true;
        }

        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return false;
        }
        if (seen[x][y]) {
            return false;
        }
        if (board[x][y] != word[idx]) {
            return false;
        }

        seen[x][y] = true;
        boolean found = dfs(board, word, idx+1, x+1, y, seen) ||
                dfs(board, word, idx+1, x-1, y, seen) ||
                dfs(board, word, idx+1, x, y+1, seen) ||
                dfs(board, word, idx+1, x, y-1, seen);
        seen[x][y] = false;
        return found;
    }

    public boolean exist1(char[][] board, String word) {
        int r = board.length;
        int c = board[0].length;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] visited = new boolean[r][c];
                    if (search(board, i, j, word, 0, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board, int x, int y, String word, int idx, boolean[][] visited) {
        if (idx == word.length()) {
            return true;
        }

        int r = board.length;
        int c = board[0].length;

        if (x < 0 || x >= r || y < 0 || y >= c) {
            return false;
        }
        if (visited[x][y]) {
            return false;
        }

        if (board[x][y] != word.charAt(idx)) {
            return false;
        }

        visited[x][y] = true;
        boolean found = search(board, x+1, y, word, idx+1, visited) ||
                search(board, x-1, y, word, idx+1, visited) ||
                search(board, x, y+1, word, idx+1, visited) ||
                search(board, x, y-1, word, idx+1, visited);
        visited[x][y] = false;
        return found;
    }
}
