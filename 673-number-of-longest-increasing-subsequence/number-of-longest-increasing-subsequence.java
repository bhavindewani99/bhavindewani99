class Solution {
    public int findNumberOfLIS(int[] nums) {
        int res = 0;
        int maxi = 1;
        int n = nums.length;
        int[] dp = new int[n];
        int[] cnt = new int[n];
        for(int i=0;i<n;i++) {
            dp[i]=1;
            cnt[i]=1;
        }

        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i] && dp[i]<1+dp[j]){
                    dp[i]=1+dp[j];
                    cnt[i]=cnt[j];
                }else if(nums[j]<nums[i] && dp[i]==1+dp[j]){
                    cnt[i]+=cnt[j];
                }
            }
            maxi = Math.max(maxi,dp[i]);
        }
        for(int i=0;i<n;i++){
            if(dp[i]==maxi) res += cnt[i];
        }
        
        return res;
    }
}