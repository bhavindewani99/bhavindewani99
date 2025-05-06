class Solution {
    long mod = (long) 1e9 + 7;
    public int numTilings(int n) {
        
        long[][] dp = new long[n+1][n+1];
        for(long[] temp : dp) Arrays.fill(temp, -1);

        return (int) recursion(n, n, dp);

    }

    private long recursion(int r1, int r2, long[][] dp){

        if(r1==0 && r2==0) return 1;
        if(r1<=0 || r2<=0) return 0;

        if(dp[r1][r2]!=-1) return dp[r1][r2];

        long count = 0;

        if(r1 == r2){
            count += recursion(r1-2, r2-2, dp); // horizontal tile
            count += recursion(r1-1, r2-1, dp); // vertical tile
            count += recursion(r1-2, r2-1, dp); // Inverted L tile
            count += recursion(r1-1, r2-2, dp); // Mirror L tile
        }else if(r1 > r2){
            count += recursion(r1-2, r2, dp); // horizontal tile to r1
            count += recursion(r1-2, r2-1, dp); // Inverted L Mirror tile
        }else{
            count += recursion(r1, r2-2, dp); // horizontal tile to r2
            count += recursion(r1-1, r2-2, dp); // L shape
        }

        return dp[r1][r2] = count % mod;
    }

}