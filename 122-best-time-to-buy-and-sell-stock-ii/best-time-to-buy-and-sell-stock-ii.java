class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        for(int[] temp : dp) Arrays.fill(temp, -1);
        return recursion(0, 1, prices,dp);
    }

    private int recursion(int index, int buy , int[] prices,int[][] dp){
        if(index==prices.length) return 0;
        if(dp[index][buy]!=-1) return dp[index][buy];
        int profit = 0;
        if(buy ==1){
            profit = Math.max(-prices[index] + recursion(index+1, 0, prices,dp), recursion(index+1, buy, prices,dp));
        }else{
            profit = Math.max(prices[index] + recursion(index+1, 1, prices,dp), recursion(index+1, buy, prices,dp));
        }
        return dp[index][buy] = profit;
    }
}