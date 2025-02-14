class Solution {
    public int findMaxFish(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int result = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(visited[i][j]==false && grid[i][j]>0){
                    int[] curr = {0};
                    dfs(i, j, grid, curr, m, n, visited);
                    result = Math.max(result, curr[0]);
                }
            }
        }

        return result;
    }

    private void dfs(int r, int c, int[][] grid, int[] curr, int m, int n, boolean[][] visited){
        if(r<0 || c<0 || r>=m || c>=n || grid[r][c]==0 || visited[r][c]==true) return;

        visited[r][c] = true;
        curr[0] += grid[r][c];
        dfs(r+1, c, grid, curr, m, n, visited);
        dfs(r, c+1, grid, curr, m, n, visited);
        dfs(r-1, c, grid, curr, m, n, visited);
        dfs(r, c-1, grid, curr, m, n, visited);
    }
}