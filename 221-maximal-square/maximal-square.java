class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        int res = 0;


        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || j==0){
                    dp[i][j] = matrix[i][j] - '0';
                }
                else if(matrix[i][j]=='1'){
                    int mini = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j],dp[i][j-1]));
                    dp[i][j] = 1 + mini;
                    
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res*res;
    }
}