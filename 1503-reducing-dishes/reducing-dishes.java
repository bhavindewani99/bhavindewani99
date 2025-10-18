class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        
        // Long[][] dp = new Long[satisfaction.length+1][satisfaction.length+1];
        Arrays.sort(satisfaction);
        // return (int) recursion(satisfaction, 1, 0, dp);
        return  tabulation(satisfaction);
    }

    private long recursion(int[] satisfaction, int time, int index, Long[][] dp){
        if(index >= satisfaction.length) return 0;

        if(dp[index][time]!=null) return dp[index][time];
        

        long not_take = recursion(satisfaction, time, index+1, dp);
        long take = satisfaction[index] * time + recursion(satisfaction, time+1, index+1, dp);

        dp[index][time] = Math.max(take, not_take);
        return Math.max(take, not_take);
    }

    private int tabulation(int[] satisfaction){
        int n = satisfaction.length;
        
        long[][] dp = new long[n+1][n+2];

        for(int i=n-1;i>=0;i--){
            for(int time = n;time>=1;time--){
                 long not_take = dp[i+1][time];
                long take = satisfaction[i] * time + dp[i+1][time+1];
                dp[i][time] = Math.max(take, not_take);
            }
        }

        return (int) dp[0][1];
    }
}