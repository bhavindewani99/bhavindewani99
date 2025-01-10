class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return recursion(n, dp);
    }

    private int recursion(int n, int[] dp){
        if(n<=1) return 1;
        if(dp[n]!=-1) return dp[n];
        int oneStep = recursion(n-1, dp);
        int twoSteps = 0;
        if(n>1) twoSteps = recursion(n-2, dp);
        return dp[n] = oneStep + twoSteps;
    }
}