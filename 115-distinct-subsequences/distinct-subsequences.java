class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n][m];
        return tabulation(n,m,s,t);
        // for(int[] temp : dp) Arrays.fill(temp, -1);
        // return recursion(n-1, m-1, s, t,dp);
    }

    private int tabulation(int n, int m, String s, String t){
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<=n;i++) dp[i][0]=1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
        }
        }
        return dp[n][m];
    }

    private int recursion(int i, int j, String s, String t,int[][] dp){
        if(j<0) return 1;
        if(i<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==t.charAt(j)){
            return dp[i][j] = recursion(i-1, j, s, t,dp) + recursion(i-1, j-1, s, t,dp);
        }
        return dp[i][j] = recursion(i-1, j, s, t,dp);
    }
}