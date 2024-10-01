class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];
        for(int[] temp : dp) Arrays.fill(temp,-1);
        return recursion(0, n - 1, nums,dp);
    }

    private int recursion(int i, int j, int[] nums, int[][] dp) {
        if (i > j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int maxCoins = 0;
        for (int k = i; k <= j; k++) {
            int leftVal = (i > 0) ? nums[i - 1] : 1;  
            int rightVal = (j < nums.length - 1) ? nums[j + 1] : 1;
            
            int coins = leftVal * nums[k] * rightVal 
                        + recursion(i, k - 1, nums,dp) 
                        + recursion(k + 1, j, nums,dp); 

            maxCoins = Math.max(maxCoins, coins);
        }
        return  dp[i][j] = maxCoins;
    }
}
