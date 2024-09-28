class Solution {
    public boolean isMatch(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n+1][m+1];
        for(int[] temp : dp) Arrays.fill(temp,-1);
        return recursion(n, m, s, t, dp);
    }

    private boolean recursion(int i, int j, String s, String t,int[][] dp){
        if(i==0){
            while(j!=0){
                if(t.charAt(j-1)!='*') return false;
                j--;
            }
            if(j==0) return true;
            return false;
        }
        if(j==0) return false;
        if(dp[i][j]!=-1) return dp[i][j]==1;
        if(s.charAt(i-1)==t.charAt(j-1) || t.charAt(j-1)=='?') {
            boolean res = recursion(i-1, j-1, s, t,dp);
            dp[i][j] = res ? 1 : 0;
            return res;
        }
        if(t.charAt(j-1)=='*') {
            boolean res = recursion(i-1, j-1, s, t,dp) || recursion(i, j-1, s, t, dp) || recursion(i-1, j, s, t, dp);
            dp[i][j] = res ? 1 : 0;
            return res;
        }
        dp[i][j] = 0;
        return false;
    }

}