class Solution {
    public int longestPalindromicSubsequence(String s, int k) {
        
        Integer[][][] dp = new Integer[s.length()][s.length()][k+1];
        return recursion(0, s.length()-1, k, s, dp);
    }

    private int recursion(int i, int j, int k, String s, Integer[][][] dp){
        if(i==j) return 1;
        if(i>j) return 0;

        if(dp[i][j][k] != null) return dp[i][j][k];

        int skipLeft = recursion(i+1, j, k, s, dp);
        int skipRight = recursion(i, j-1, k, s, dp);

        int difference = Math.abs(s.charAt(i)-s.charAt(j));
        difference = Math.min(difference, 26 - difference);
        int curr = 0;
        
        if(difference <= k) {
            curr = 2 + recursion(i+1, j-1, k-difference, s, dp);
        }

        return dp[i][j][k] = Math.max(curr, Math.max(skipLeft, skipRight));
    }
}