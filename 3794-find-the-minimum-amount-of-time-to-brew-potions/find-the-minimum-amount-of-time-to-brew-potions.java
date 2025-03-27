class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length, m = mana.length;
        long dp[][] = new long[m][n];

        dp[0][0] = mana[0]*skill[0];
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i-1] + (mana[0]*skill[i]);
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i-1][j]+(mana[i]*skill[j]);
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + (mana[i]*skill[j]);
                }
            }
            for (int k = n-2; k >= 0; k--) {
                dp[i][k] = (dp[i][k+1]-(mana[i]*skill[k+1]));
            }
        }
        return dp[m-1][n-1];
    }
}