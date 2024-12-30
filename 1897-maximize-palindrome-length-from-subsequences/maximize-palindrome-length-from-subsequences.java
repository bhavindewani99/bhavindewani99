class Solution {
    public int longestPalindrome(String word1, String word2) {
        String s = word1 + word2;
        int n = word1.length();
        int[] ans = {0};
        int[][] dp = new int[s.length()][s.length()];
        for(int[] temp : dp) Arrays.fill(temp, -1);
        lps(0, s.length()-1, s, n, ans, dp);
        return ans[0];
        
    }

    private int lps(int l, int r, String s, int word1Len, int[] ans, int[][] dp){
        if(l>r) return 0;
        if(l==r) return 1;

        if(dp[l][r]!=-1) return dp[l][r];

        int len = 0;

        if(s.charAt(l)==s.charAt(r)){
            len = 2 + lps(l+1, r-1, s, word1Len, ans,dp);
            if(l < word1Len && r>= word1Len){
                ans[0] = Math.max(ans[0], len);
            }
        }
        else{
            len = Math.max(lps(l+1, r, s, word1Len, ans, dp), lps(l, r-1, s, word1Len, ans, dp));
        }
        return dp[l][r] = len;
    }


}