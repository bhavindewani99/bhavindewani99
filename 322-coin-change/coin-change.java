class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] temp : dp) Arrays.fill(temp, -1);
        int res = recursion(n-1, amount, coins,dp);
        return res>= (int)1e9 ? -1 : res;
    }

    private int recursion(int index, int amount, int[] coins,int[][] dp){
        if(amount==0) return 0;
        if(amount<0) return (int)1e9;
        if(index==0){
            if(amount >= coins[0] && amount%coins[0]==0) return amount/coins[0];
            return (int) 1e9;
        }
        if(dp[index][amount]!=-1) return dp[index][amount];
        int not_take = recursion(index-1, amount, coins,dp);
        int take = (int) 1e9;
        if(coins[index]<=amount){
            take = 1 + recursion(index, amount-coins[index],coins ,dp);
        }
        return dp[index][amount] =  Math.min(take,not_take);
    }
}