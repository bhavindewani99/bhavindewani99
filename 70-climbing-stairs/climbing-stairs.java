class Solution {
    public int climbStairs(int n) {
        return tabulation(n);
        // int[] dp = new int[n+1];
        // Arrays.fill(dp, -1);
        // return recursion(n, dp);
    }

    private int tabulation(int n){
        int zero = 1;
        int one =1;
        for(int i=2;i<=n;i++){
            int sum = zero + one;
            zero = one;
            one = sum;

        }
        return one;

    }

    private int recursion(int n, int[] dp){
        if(n<=1) return 1;
        if(dp[n]!=-1) return dp[n];
        int oneStep = recursion(n-1, dp);
        int twoSteps = 0;
        if(n>1) twoSteps = recursion(n-2, dp);
        return dp[n] = oneStep + twoSteps;
    }
}