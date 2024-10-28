class Solution {
    public boolean isValidPalindrome(String s, int k) {
        int[][] dp = new int[s.length()][s.length()];
        for(int[] temp : dp) Arrays.fill(temp, -1);
        int result = recursion(s, k, 0, s.length()-1,dp);
        return result<=k;
    }


    private int recursion(String s,int k, int l, int r,int[][] dp){
        if(l>r) return 0;
        if(dp[l][r]!=-1) return dp[l][r];
        if(s.charAt(l)==s.charAt(r)){
            dp[l][r] = recursion(s, k, l+1, r-1,dp);
        }else{
            dp[l][r] = 1 +  Math.min(recursion(s,k,l+1,r,dp), recursion(s, k, l, r-1,dp));
        }
        return dp[l][r];
    }
}