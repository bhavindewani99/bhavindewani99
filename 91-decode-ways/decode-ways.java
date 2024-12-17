class Solution {
    public int numDecodings(String s) {
        return tabulation(s);
        // int n = s.length();
        // int[] dp = new int[n+1];
        // Arrays.fill(dp, -1);
        // return recursion(0, s, dp);
    }

    private int tabulation(String s){
        int n = s.length();
        int[] dp = new int[n+1];
        dp[n]=1;
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i)=='0'){
                dp[i]=0;
            }else{
                dp[i] += dp[i+1];
                if(i+1<n && Integer.valueOf(s.substring(i,i+2))<27){
                    dp[i] += dp[i+2];
                }
            }
        }
        return dp[0];
    }


    private int recursion(int index,String s, int[] dp){
        if(index>=s.length()) return 1;
        if(s.charAt(index)=='0') return 0;
        if(dp[index]!=-1) return dp[index];
        int one = recursion(index+1, s, dp);
        int two = 0;
        if(index+1<s.length()){
            two = recursion(index+2, s, dp);
        }
        return dp[index] = one + two;
    }
}