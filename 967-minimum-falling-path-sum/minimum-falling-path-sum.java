class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        int m = matrix.length, n = matrix[0].length;
        Integer[][] dp = new Integer[m][n];
        int result = Integer.MAX_VALUE;

        for(int j=0;j<n;j++){
            result = Math.min(result, recursion(matrix, m, n, 0, j,dp));
        }

        return result;
    }

    private int recursion(int[][] matrix, int m, int n, int row, int col, Integer[][] dp){

        if(col>=n || col<0) return (int) 1e9;
        if(row==m-1) return matrix[row][col];

        if(dp[row][col] != null) return dp[row][col];

        int down = recursion(matrix, m, n, row+1, col, dp);
        int left = recursion(matrix, m, n, row+1, col-1, dp);
        int right = recursion(matrix, m, n, row+1, col+1, dp);

        return dp[row][col] = matrix[row][col] + Math.min(down, Math.min(left, right));
    }
}