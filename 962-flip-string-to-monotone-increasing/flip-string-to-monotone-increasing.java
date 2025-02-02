class Solution {
    public int minFlipsMonoIncr(String s) {
        Integer[][] dp = new Integer[s.length()][2];
        return recursion(0,0,s,dp);
    }

    private int recursion(int index, int prev, String s,Integer[][] dp){
        if(index>=s.length()) return 0;

        if(dp[index][prev]!=null) return dp[index][prev];
        
        int flip = Integer.MAX_VALUE, not_flip = Integer.MAX_VALUE;

        if(s.charAt(index)=='0'){
            if(prev == 0){
                not_flip = recursion(index+1, prev, s,dp);
                flip = 1 + recursion(index+1, 1, s, dp);
            }else{
                flip = 1 + recursion(index+1, prev, s, dp);
            }
        }else{
            if(prev == 0){
                flip = 1 + recursion(index+1, 0, s, dp);
                not_flip = recursion(index+1, 1, s, dp);
            }else{
                not_flip = recursion(index+1, prev, s, dp);
            }
        }
        return dp[index][prev] = Math.min(flip, not_flip);
    }
}