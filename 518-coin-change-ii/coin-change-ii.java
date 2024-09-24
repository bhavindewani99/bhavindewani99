

import static java.lang.System.in;

class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] temp : dp) Arrays.fill(temp, -1);
        return recursion(n-1, amount, coins,dp);
    }

    private int recursion(int index, int amount, int[] coins,int[][] dp){
        if(amount==0) return 1;
        if(index==0) {
            if(coins[0]<=amount && amount%coins[0]==0) return 1;
            return 0;
        }
        if(dp[index][amount]!=-1) return dp[index][amount];
        int not_take = recursion(index-1, amount, coins,dp);
        int take = 0;
        if(amount>=coins[index]){
            take = recursion(index, amount-coins[index], coins,dp);
        }
        return dp[index][amount] = take + not_take;
    }
}