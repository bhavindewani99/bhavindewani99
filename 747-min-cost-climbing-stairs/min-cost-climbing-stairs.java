class Solution {
    public int minCostClimbingStairs(int[] cost) {
        return tabulation(cost);
        // int[] dp = new int[cost.length+1];
        // Arrays.fill(dp,-1);
        // return Math.min(recursion(0,cost,dp), recursion(1,cost,dp));
    }

    private int tabulation(int[] cost){
        int n = cost.length;
        int[] dp = new int[n+2];
        for(int i=n-1;i>=0;i--){
            int step1 = cost[i]+ dp[i+1];
            int step2 = cost[i] + dp[i+2];
            dp[i] = Math.min(step1,step2);
        }
        return Math.min(dp[0],dp[1]);
    }

    private int recursion(int index, int[] cost, int[] dp){
        if(index>=cost.length) return 0;
        if(dp[index]!=-1) return dp[index];
        int step1 = cost[index]+ recursion(index+1,cost,dp);
        int step2 = cost[index] + recursion(index+2,cost,dp);
        return dp[index] = Math.min(step1,step2);
    }
}