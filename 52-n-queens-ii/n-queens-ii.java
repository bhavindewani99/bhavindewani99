import java.util.HashSet;
import java.util.Set;

class Solution {
    public int totalNQueens(int n) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> diag1 = new HashSet<>(); // row - col
        Set<Integer> diag2 = new HashSet<>(); // row + col

        return backtrack(0, n, rows, diag1, diag2);
    }

    private int backtrack(int col, int n, Set<Integer> rows, Set<Integer> diag1, Set<Integer> diag2) {
        if (col == n) return 1; // placed all queens

        int count = 0;
        for (int row = 0; row < n; row++) {
            if (rows.contains(row) || diag1.contains(row - col) || diag2.contains(row + col)) {
                continue;
            }

            // place queen
            rows.add(row);
            diag1.add(row - col);
            diag2.add(row + col);

            count += backtrack(col + 1, n, rows, diag1, diag2);

            // backtrack
            rows.remove(row);
            diag1.remove(row - col);
            diag2.remove(row + col);
        }
        return count;
    }
}
