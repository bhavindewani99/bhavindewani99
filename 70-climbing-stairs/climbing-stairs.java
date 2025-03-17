class Solution {
    public int climbStairs(int n) {
        Integer[] dp = new Integer[n+1];
        return recursion(n, dp);
    }

    private int recursion(int n, Integer[] dp){
        if(n<0) return 0;
        if(n==0) return 1;

        if(dp[n]!=null) return dp[n];

        return dp[n]= recursion(n-1, dp) + recursion(n-2, dp);

    }
}