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
                    
                    result = Math.max(result, dfs(i, j, grid, curr, m, n, visited));
                }
            }
        }

        return result;
    }

    private int dfs(int r, int c, int[][] grid, int[] curr, int m, int n, boolean[][] visited){
        if(r<0 || c<0 || r>=m || c>=n || grid[r][c]==0 || visited[r][c]==true) return 0;
        int total = grid[r][c];
        visited[r][c] = true;
        //curr[0] += grid[r][c];
        total += dfs(r+1, c, grid, curr, m, n, visited);
        total += dfs(r, c+1, grid, curr, m, n, visited);
        total += dfs(r-1, c, grid, curr, m, n, visited);
        total += dfs(r, c-1, grid, curr, m, n, visited);
        return total;
    }
}