class Solution {
    public int getMaximumGold(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int gold  = 0;
        int[][] directions = {{-1,0} ,{0,1},{1,0},{0,-1}};

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]!=0){
                    gold = Math.max(gold, dfs(i,j,m,n,grid,visited,directions));
                }
            }
        }
        return gold;
    }

    private int dfs(int i, int j, int m , int n, int[][] grid, boolean[][] visited, int[][] directions){
        if(i<0 || j<0 || i>=m ||j >=n || visited[i][j] || grid[i][j]==0) return 0;

        int gold = grid[i][j];
        int maxi = 0;
        visited[i][j] = true;

        for(int d=0;d<4;d++){
            maxi = Math.max(maxi, dfs( i + directions[d][0], j+directions[d][1], m, n, grid, visited, directions));
        }

        visited[i][j] = false;
        return gold + maxi;
        
    }



}