class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int maxi = -1;
        for(int i:days) maxi = Math.max(i, maxi);
        int[][] dp = new int[n+1][maxi+30];
        for(int[] temp : dp)
        Arrays.fill(temp, -1);
        return(recursion(0, days, costs, 0,dp));
    }

    private int recursion(int index, int[] days, int[] costs, int last,int[][] dp){
        if(index>=days.length) return 0;
        if(dp[index][last]!=-1) return dp[index][last];
        if(last>=days[index]) return recursion(index+1, days, costs, last,dp);
        int one = costs[0] + recursion(index+1, days, costs, days[index],dp);
        int week  = costs[1] + recursion(index+1, days, costs,  days[index] + 7 -1,dp);
        int month = costs[2] + recursion(index+1, days, costs, days[index] + 30 -1,dp);

        return dp[index][last] = Math.min(one, Math.min(week, month));
        
    }
}