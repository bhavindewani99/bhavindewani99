class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        
        // Long[][] dp = new Long[satisfaction.length+1][satisfaction.length+1];
        Arrays.sort(satisfaction);
        // return (int) recursion(satisfaction, 1, 0, dp);
        //return  tabulation(satisfaction);
        return greedy(satisfaction);
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
        
        long[] dp = new long[n+2];

        for(int i=n-1;i>=0;i--){
            long[] temp = new long[n+2];
            for(int time = n;time>=1;time--){
                 long not_take = dp[time];
                long take = satisfaction[i] * time + dp[time+1];
                temp[time] = Math.max(take, not_take);
            }
            dp = temp;
        }

        return (int) dp[1];
    }

    // since we are adding suffix everytime no need to mutlily
    //Step	Chosen Dishes	suffixSum	    New Total
    // start	   []	         0	          0
    // add 5	[5]	            5	          +5
    // add 0	[0, 5]	    5 + 0 = 5	      +5 → 10
    // add -1	[-1, 0, 5]	   4	          +  4 → 14
    // add -8	[-8, -1, 0, 5]	-4	stop (since suffixSum < 0)
    private int greedy(int[] satisfaction){
        int n = satisfaction.length;
        int suffixSum =0 , result = 0;

        for(int i=n-1;i>=0;i--){
            suffixSum += satisfaction[i];
            if(suffixSum < 0) break;
            result += suffixSum;
        }
        return result;
    }
}