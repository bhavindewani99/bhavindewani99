class Solution {
    int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    int mod = (int) 1e9 + 7;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        
        Integer[][][] dp = new Integer[m][n][maxMove+1]; 
        return dfs(startRow, startColumn, m,n, maxMove, dp);
    }


    private int dfs(int r, int c, int m, int n, int maxMove, Integer[][][] dp){

        if(r<0 || c<0 || r>=m || c>=n) return 1;
        if(maxMove == 0) return 0;
        if(dp[r][c][maxMove] != null) return dp[r][c][maxMove];

        dp[r][c][maxMove] = (((dfs(r+1,c,m,n,maxMove-1,dp) + dfs(r-1,c,m,n,maxMove-1,dp)) % mod) + ((dfs(r,c-1,m,n,maxMove-1,dp) + dfs(r,c+1,m,n,maxMove-1,dp)) % mod)) % mod;

        return dp[r][c][maxMove];
    }
}