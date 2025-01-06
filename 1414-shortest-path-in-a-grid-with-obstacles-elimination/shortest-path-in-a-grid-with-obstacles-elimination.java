import java.util.*;

class Solution {
    public int shortestPath(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        Queue<int[]> queue = new LinkedList<>();
        Set<String> seen = new HashSet<>();

        queue.offer(new int[]{0, 0, 0, k});
        seen.add(encode(0, 0, k));

        while (!queue.isEmpty()) {
            int[] state = queue.poll();
            int row = state[0];
            int col = state[1];
            int steps = state[2];
            int remainingK = state[3];

            if (row == n - 1 && col == m - 1) return steps;

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < m) {
                    int newRemainingK = remainingK - grid[newRow][newCol];

                    if (newRemainingK >= 0) {
                        String encodedState = encode(newRow, newCol, newRemainingK);
                        if (seen.add(encodedState)) {
                            queue.offer(new int[]{newRow, newCol, steps + 1, newRemainingK});
                        }
                    }
                }
            }
        }

        return -1;
    }

    private String encode(int row, int col, int k) {
        return row + "," + col + "," + k;
    }
}
