class Solution {
    public int maxProfit(int[] prices) {
        int n =prices.length;
        int[][][] dp = new int[n+1][2][3];
        for(int[][] curr : dp){
            for(int[] temp : curr) Arrays.fill(temp, -1);
        }
        return recursion(0, 1, 0, prices,dp);
    }

    private int recursion(int index, int buy, int transaction, int[] prices,int[][][] dp){
        if(index==prices.length) return 0;
        if(dp[index][buy][transaction]!=-1) return dp[index][buy][transaction];
        int profit = 0;
        if(buy==1){
            if(transaction<=1){
                profit = Math.max(-prices[index] + recursion(index+1, 0, transaction, prices,dp), recursion(index+1, buy, transaction, prices,dp));
            }
        }else{
            profit = Math.max(prices[index] + recursion(index+1, 1, transaction+1, prices,dp), recursion(index+1, buy, transaction, prices,dp));
        }
        return dp[index][buy][transaction] = profit;
    }
}