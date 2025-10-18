class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        
        Long[][] dp = new Long[satisfaction.length+1][satisfaction.length+1];
        Arrays.sort(satisfaction);
        return (int) recursion(satisfaction, 1, 0, dp);
    }

    private long recursion(int[] satisfaction, int time, int index, Long[][] dp){
        if(index >= satisfaction.length) return 0;

        if(dp[index][time]!=null) return dp[index][time];
        

        long not_take = recursion(satisfaction, time, index+1, dp);
        long take = satisfaction[index] * time + recursion(satisfaction, time+1, index+1, dp);

        dp[index][time] = Math.max(take, not_take);
        return Math.max(take, not_take);
    }
}