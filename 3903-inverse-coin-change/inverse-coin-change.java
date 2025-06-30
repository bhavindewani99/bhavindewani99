class Solution {
    public List<Integer> findCoins(int[] numWays) {
        
        int n = numWays.length;
        List<Integer> result = new ArrayList<>();
        int[] dp = new int[n+1];
        dp[0] = 1; // because for amount 1 we will do 1-1 so there be 1 coin right of amount 1

        for(int i=1;i<=n;i++){
            if(dp[i] == numWays[i-1]) continue;

            if(dp[i] + 1 == numWays[i-1]){
                result.add(i);

                for(int j=i;j<=n;j++){
                    dp[j] += dp[j-i];
                }
            }else{
                return new ArrayList<>();
            }
        }
        return result;
    }
}