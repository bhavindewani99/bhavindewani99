class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {

        Pair[][] grid = new Pair[n][n];
        int result = 0;

        // FIX: create a unique Pair for every cell
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = new Pair();
            }
        }

        // mark mines
        for (int[] mine : mines) {
            grid[mine[0]][mine[1]].setZero();
        }

        // left and up
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j].val == 0) continue;

                int left = (j > 0) ? grid[i][j - 1].left : 0;
                int up   = (i > 0) ? grid[i - 1][j].up   : 0;

                grid[i][j].left = 1 + left;
                grid[i][j].up   = 1 + up;
            }
        }

        // right and down
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j].val == 0) continue;

                int right = (j < n - 1) ? grid[i][j + 1].right : 0;
                int down  = (i < n - 1) ? grid[i + 1][j].down  : 0;

                grid[i][j].right = 1 + right;
                grid[i][j].down  = 1 + down;
            }
        }

        // compute answer
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result = Math.max(result, grid[i][j].getMin());
            }
        }

        return result;
    }

    class Pair {
        int up = 1, down = 1, left = 1, right = 1, val = 1;

        void setZero() {
            up = down = left = right = val = 0;
        }

        int getMin() {
            return Math.min(Math.min(up, down), Math.min(left, right));
        }
    }
}
