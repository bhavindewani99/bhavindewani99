class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return recursion(0, s, dp);
    }


    private int recursion(int index,String s, int[] dp){
        if(index>=s.length()) return 1;
        if(s.charAt(index)=='0') return 0;
        if(dp[index]!=-1) return dp[index];
        int one = recursion(index+1, s, dp);
        int two = 0;
        if(index+1<s.length() && Integer.valueOf(s.substring(index,index+2))<27){
            two = recursion(index+2, s, dp);
        }
        return dp[index] = one + two;
    }
}