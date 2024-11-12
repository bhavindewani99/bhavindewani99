class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        Arrays.fill(dp,-1);
        return Math.min(recursion(0,cost,dp), recursion(1,cost,dp));
    }

    // private int tabulation(int[] cost){
    //     int[]
    // }

    private int recursion(int index, int[] cost, int[] dp){
        if(index>=cost.length) return 0;
        if(dp[index]!=-1) return dp[index];
        int step1 = cost[index]+ recursion(index+1,cost,dp);
        int step2 = cost[index] + recursion(index+2,cost,dp);
        return dp[index] = Math.min(step1,step2);
    }
}