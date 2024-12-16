class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        double[][][] dp = new double[n][n][k+1];
        for(double[][] temp : dp){
            for(double[] curr : temp) Arrays.fill(curr, -1.0);
        }

        return recursion(n,k,row,column,dp);
    }

    private double recursion(int n, int k, int row, int col, double[][][] dp){
        if(row<0 || col<0 || row>=n || col>=n) return 0;
        if(k==0) return 1.0;
        if(dp[row][col][k]!=-1.0) return dp[row][col][k];
        int[][] directions = {{-2,-1}, {-2,1}, {-1,2}, {1,2}, {2,1}, {2,-1}, {1,-2}, {-1,-2}};
        double result = 0;

        for(int dir =0;dir<8;dir++){
            int x = directions[dir][0] + row;
            int y = directions[dir][1] + col;
            result += recursion(n, k-1, x, y, dp);
        }
        dp[row][col][k] = result/8.0;
        return result/8.0;

    }
}