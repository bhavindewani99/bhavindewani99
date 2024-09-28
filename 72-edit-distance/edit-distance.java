class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n+1][m+1];
        for(int[] temp : dp) Arrays.fill(temp, -1);
        return recursion(n,m,word1,word2, dp);
    }

    private int recursion(int i, int j, String s, String t, int[][] dp){
        if(i==0) return j;
        if(j==0) return i;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i-1)==t.charAt(j-1)){
            return dp[i][j]= recursion(i-1,j-1,s,t,dp);
        }
        return dp[i][j] = 1 + Math.min(recursion(i-1,j,s,t,dp), Math.min(recursion(i,j-1,s,t,dp),recursion(i-1,j-1,s,t,dp)));
    }
}