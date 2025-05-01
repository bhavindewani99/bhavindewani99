class Solution {
    public long minTime(int[] skill, int[] mana) {
        
        int skillLen = skill.length, manaLen = mana.length;
        long[][] dp = new long[manaLen][skillLen];

        dp[0][0] = mana[0]*skill[0];
        for(int i=1;i<skillLen;i++){
            dp[0][i] = dp[0][i-1] + mana[0]*skill[i];
        }


        for(int i=1;i<manaLen;i++){
            for(int j=0;j<skillLen;j++){
                if(j==0){
                    dp[i][j] = dp[i-1][j] + mana[i]*skill[j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1])+ mana[i]*skill[j];
                }
            }

            // Actual Time Taken
            for(int j=skillLen-2;j>=0;j--){
                dp[i][j] = dp[i][j+1] - mana[i]*skill[j+1];
            }
        }

        return dp[manaLen-1][skillLen-1];
    }
}