class Solution {
    public int maxProfit(int k, int[] prices) {
        int[][][] dp = new int[prices.length+1][2][k+1];
        for(int[][] temp : dp){
            for(int[] curr : temp) Arrays.fill(curr, -1);
        }
        return recursion(k, prices, 0, 1, dp);
        // int n =prices.length;
        // return tabulation(n, prices,k);
    }

    // private int tabulation(int n, int[] prices,int k){
    //     int[][][] dp = new int[n+1][2][k+1];
    //     for(int index=n-1;index>=0;index--){
    //         for(int buy =0;buy<=1;buy++){
    //             for(int transaction=k-1;transaction>=0;transaction--){
    //                 int profit = 0;
    //                 if(buy==1){
    //                     profit = Math.max(-prices[index] + dp[index+1][0][transaction], dp[index+1][buy][transaction]);
    //                 }else{
    //                     profit = Math.max(prices[index] + dp[index+1][1][transaction+1], dp[index+1][buy][transaction]);
    //                 }
    //                 dp[index][buy][transaction] = profit;
    //             }
    //         }
    //     }
    //     return dp[0][1][0];
    // }

    private int recursion(int k, int[] prices, int index, int buy, int[][][] dp){
        if(index>=prices.length || k<=0) return 0;
        int profit = 0;
        if(dp[index][buy][k]!=-1) return dp[index][buy][k];
        
        if(buy==1){
            profit = Math.max(-prices[index] + recursion(k, prices, index+1, 0, dp), recursion(k, prices, index+1, buy, dp));
        }else{
            profit = Math.max(prices[index] + recursion(k-1, prices, index+1, 1, dp), recursion(k, prices, index+1, buy, dp));
        }
        dp[index][buy][k] = profit;

        return profit;
    }
}