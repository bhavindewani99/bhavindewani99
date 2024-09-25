class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        return tabulation(n, m, text1, text2);
        // int[][] dp = new int[n+1][m+1];
        // for(int[] temp : dp) Arrays.fill(temp, -1);
        // return recurison(n, m, text1, text2,dp);
    }

    private int tabulation(int n, int m, String text1, String text2){
        int[][] dp = new int[n+1][m+1];
        for(int index1=1;index1<=n;index1++){
            for(int index2=1;index2<=m;index2++){
                if(text1.charAt(index1-1)==text2.charAt(index2-1)){
                    dp[index1][index2] = 1 + dp[index1-1][index2-1];
                }else{
                    dp[index1][index2] = Math.max(dp[index1-1][index2],dp[index1][index2-1]);
                }
            }
        }
        return dp[n][m];
    }

    private int recurison(int index1, int index2, String text1, String text2,int[][] dp){
        if(index1==0 || index2==0) return 0;
        if(dp[index1][index2]!=-1) return dp[index1][index2];
        if(text1.charAt(index1-1)==text2.charAt(index2-1)){
            return dp[index1][index2] = 1 + recurison(index1-1, index2-1, text1, text2,dp);
        }
        return dp[index1][index2] =Math.max(recurison(index1-1,index2,text1,text2,dp), recurison(index1,index2-1,text1,text2,dp));
    }
}