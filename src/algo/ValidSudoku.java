package algo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int r = board.length;
        int c = board[0].length;

        Map<Integer, Set<Integer>> rowsToValues = new HashMap<>();
        Map<Integer, Set<Integer>> colsToValues = new HashMap<>();
        Map<Integer, Set<Integer>> cellsToValues = new HashMap<>();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int cell = (i%3) + 3*(j%3);
                char ch = board[i][j];
                if (Character.isDigit(ch)) {
                    int val = ch - '0';

                    Set<Integer> rowValues = rowsToValues.getOrDefault(i, new HashSet<>());
                    if (rowValues.contains(val)) {
                        return false;
                    }
                    rowValues.add(val);
                    rowsToValues.put(i, rowValues);

                    Set<Integer> colValues = colsToValues.getOrDefault(j, new HashSet<>());
                    if (colValues.contains(val)) {
                        return false;
                    }
                    colValues.add(val);
                    colsToValues.put(j, colValues);

                    Set<Integer> cellValues = cellsToValues.getOrDefault(cell, new HashSet<>());
                    if (cellValues.contains(val)) {
                        return false;
                    }
                    cellValues.add(val);
                    cellsToValues.put(cell, cellValues);
                }
            }
        }
        return true;
    }
}
