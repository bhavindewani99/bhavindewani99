class Solution {
    public long mostPoints(int[][] questions) {

        Long[] dp = new Long[questions.length+1];
        return recursion(questions, 0, dp);
    }


    private long recursion(int[][] questions, int index, Long[] dp){
        if(index >= questions.length) return 0;

        if(dp[index] != null) return dp[index];
         
        long not_take = recursion(questions, index+1, dp);

        int newIndex = Math.min(questions.length, index + questions[index][1] + 1);
        long take = questions[index][0] + recursion(questions, newIndex, dp);

        return dp[index] = Math.max(take, not_take);
    }
}