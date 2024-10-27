class Solution {
    public int coinChange(int[] coins, int amount) {
        return tabulation(coins, amount);
        // int n = coins.length;
        // int[][] dp = new int[n][amount+1];
        // for(int[] temp : dp) Arrays.fill(temp, -1);
        // int res = recursion(n-1, amount, coins,dp);
        // return res>= (int)1e9 ? -1 : res;
    }

    private int tabulation(int[] coins, int amount){
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int i=0;i<=amount;i++){
            if(i%coins[0]==0) dp[0][i] = i/coins[0];
            else dp[0][i] =(int) 1e9;
        }

        for(int i=1;i<n;i++){
            for(int target=1;target<=amount;target++){
                int not_take = dp[i-1][target];
                int take = (int) 1e9;
                if(coins[i]<=target){
                    take = 1 + dp[i][target-coins[i]];
                } 
                dp[i][target] = Math.min(take,not_take);
            }
        }
        return dp[n-1][amount] >= (int) 1e9 ? -1 : dp[n-1][amount];
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