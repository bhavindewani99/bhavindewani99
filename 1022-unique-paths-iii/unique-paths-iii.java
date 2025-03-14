class Solution {
    public int uniquePathsIII(int[][] grid) {
        int m = grid.length, n = grid[0].length, startX = 0, startY = 0;
        int empty = 0;  // Count walkable squares (0s only)

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                } else if (grid[i][j] == 0) {
                    empty++;
                }
            }
        }

        return dfs(grid, startX, startY, empty, m, n);
    }

    private int dfs(int[][] grid, int r, int c, int empty, int m, int n) {
        if (r < 0 || c < 0 || r >= m || c >= n || grid[r][c] == -1) return 0;

        // If we reach the end, check if all empty cells were visited
        if (grid[r][c] == 2) return empty == -1 ? 1 : 0;  // -1 because last empty gets counted before reaching '2'

        // Mark as visited
        grid[r][c] = -1;
        empty--;

        int paths = dfs(grid, r + 1, c, empty, m, n)
                  + dfs(grid, r - 1, c, empty, m, n)
                  + dfs(grid, r, c + 1, empty, m, n)
                  + dfs(grid, r, c - 1, empty, m, n);

        // Backtrack (restore state)
        grid[r][c] = 0;
        empty++;

        return paths;
    }
}
