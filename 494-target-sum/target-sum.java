class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n][2001];
        for(int [] temp : dp) Arrays.fill(temp, -1);
        return recursion(n-1, 0, target, nums,dp);
    }

    private int recursion(int index, int currSum, int target, int[] nums,int[][] dp){
        if(index<0) return currSum==target ? 1 : 0;
        if(dp[index][currSum+1000]!=-1) return dp[index][currSum+1000];
        int plus = recursion(index-1, currSum+nums[index], target, nums,dp);
        int minus = recursion(index-1, currSum-nums[index], target, nums,dp);
        return dp[index][currSum+1000] =  plus + minus;
    }
}