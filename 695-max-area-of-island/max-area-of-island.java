class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int res = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && visited[i][j]==false){
                    res = Math.max(res,dfs(i, j, visited, grid, n, m));
                }
            }
        }
        return res;
    }

    private int dfs(int i, int j, boolean[][] visited, int[][] grid, int n, int m){
        //if(grid[i][j]==0 || visited[i][j]==true) return 0;
        int[] rows = {-1,0,1,0};
        int[] cols = {0,1,0,-1};
        visited[i][j]=true;
        int area = 1;
        for(int index =0;index<4;index++){
            int r = i + rows[index];
            int c = j + cols[index];
            if(r>=0 && c>=0 && r<n && c < m && visited[r][c]==false && grid[r][c]==1){
                area += dfs(r, c, visited, grid, n, m);
            }
        }
        return area;
    }
}