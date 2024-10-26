class Solution {
    public int maxProfit(int[] prices) {
        // int res = 0;
        // int sell = prices[prices.length-1];
        // for(int i=prices.length-2;i>=0;i--){
        //     if(prices[i]<sell){
        //         res = Math.max(res, sell-prices[i]);
        //     }else{
        //         sell = prices[i];
        //     }
        // }
        // return res;
        int maxCur = 0, maxSoFar = 0;
        for(int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }
}