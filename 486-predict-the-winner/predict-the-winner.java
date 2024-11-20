class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];

        for(int[] temp : dp) Arrays.fill(temp, -1);
        return recursion(0, n-1, nums, dp)>=0;
    }

    private int recursion(int i, int j, int[] nums, int[][] dp){
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];

        int left = nums[i] - recursion(i+1, j, nums, dp);
        int right = nums[j] - recursion(i, j-1, nums, dp);

        return dp[i][j] = Math.max(left, right);

    }
}