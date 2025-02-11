class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Integer[][] dp = new Integer[costs.length][costs.length];
        return recursion(costs, 0, 0, dp);
    }

    private int recursion(int[][] costs,int a, int b, Integer[][] dp){
        if(a+b==costs.length){
            if(a==b) return 0;
            return (int) 1e9;
        }
        if(dp[a][b]!=null) return dp[a][b];
        int citya = costs[a+b][0] + recursion(costs, a+1, b, dp);
        int cityb = costs[a+b][1] + recursion(costs, a, b+1, dp);
        return dp[a][b] =  Math.min(citya, cityb);
    }
}