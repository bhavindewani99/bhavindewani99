

import static java.lang.System.in;

class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        return tabulation(amount, coins, n);
        // int[][] dp = new int[n][amount+1];
        // for(int[] temp : dp) Arrays.fill(temp, -1);
        // return recursion(n-1, amount, coins,dp);
    }

    private int tabulation(int target,int[] coins, int n){
        int[][] dp = new int[n][target+1];
        for(int i=0;i<n;i++) dp[i][0] = 1;
        for(int amount=0;amount<=target;amount++){
            if(coins[0]<=amount && amount%coins[0]==0) dp[0][amount]=1;
        }

        for(int index=1;index<n;index++){
            for(int amount=1;amount<=target;amount++){
                dp[index][amount] = dp[index-1][amount];
                if(amount>=coins[index]){
                    dp[index][amount] += dp[index][amount-coins[index]];
                }
            }
        }
        return dp[n-1][target];
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