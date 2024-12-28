class Solution {
    int MOD = 1000000007;
    public int countTexts(String pressedKeys) {
        int[] dp = new int[pressedKeys.length()];
        Arrays.fill(dp, -1);
        return f(pressedKeys,0,dp);
    }

    public int f(String keys,int index,int[] dp){
        if(index >= keys.length()){
            return 1;
        }
        if(dp[index] != -1){
            return dp[index];
        }
        int take_one = 0;
        int take_two = 0;
        int take_three = 0;
        int take_four = 0;
        take_one = f(keys,index+1,dp)%MOD;
        if(index < keys.length() - 1 && keys.charAt(index) == keys.charAt(index+1)){
            take_two = f(keys,index+2,dp)%MOD;
        }
        if(index < keys.length()-2 && keys.charAt(index) == keys.charAt(index+1) && keys.charAt(index) == keys.charAt(index+2)){
            take_three = f(keys,index+3,dp)%MOD;
        }
        if(keys.charAt(index) == '7' || keys.charAt(index) == '9'){
            if(index < keys.length()-3 && keys.charAt(index) == keys.charAt(index+1) && keys.charAt(index) == keys.charAt(index+2) && keys.charAt(index) == keys.charAt(index+3)){
                take_four = f(keys,index+4,dp)%MOD;
            }
        }
        return dp[index] = ((take_one + take_two)%MOD + (take_four+take_three)%MOD)%MOD;
    }
}