class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> pacific = new HashSet<>();
        Set<List<Integer>> atlantic = new HashSet<>();
        int n = heights.length;
        int m = heights[0].length;

        // first row and last row
        for (int c = 0; c < m; c++) {
            dfs(0, c, heights[0][c], pacific, n, m, heights);
            dfs(n - 1, c, heights[n - 1][c], atlantic, n, m, heights);
        }

        // first col and last col
        for (int r = 0; r < n; r++) {
            dfs(r, 0, heights[r][0], pacific, n, m, heights);
            dfs(r, m - 1, heights[r][m - 1], atlantic, n, m, heights);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                List<Integer> curr = new ArrayList<>();
                curr.add(i);
                curr.add(j);
                if (pacific.contains(curr) && atlantic.contains(curr)) {
                    result.add(curr);
                }
            }
        }
        return result;
    }

    private void dfs(int r, int c, int prevHeight, Set<List<Integer>> visited, int n, int m, int[][] heights) {
        List<Integer> curr = new ArrayList<>();
        curr.add(r);
        curr.add(c);
        if (r < 0 || c < 0 || r >= n || c >= m || visited.contains(curr) || heights[r][c] < prevHeight) return;
        visited.add(curr);

        dfs(r + 1, c, heights[r][c], visited, n, m, heights);
        dfs(r, c - 1, heights[r][c], visited, n, m, heights);
        dfs(r - 1, c, heights[r][c], visited, n, m, heights);
        dfs(r, c + 1, heights[r][c], visited, n, m, heights);
    }
}
