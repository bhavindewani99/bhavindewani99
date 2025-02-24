

import static java.lang.System.in;

class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i: nums) sum+=i;
        if(sum%2!=0) return false;
        //return spaceOtpmization(nums,sum/2);
        //return tabulation(nums,sum/2);
        int n = nums.length;
        int[][] dp = new int[n][sum/2+1];
        for(int[] temp : dp) Arrays.fill(temp, -1);
        return recusrion(n-1, nums, sum/2,dp);
    }

    private boolean spaceOtpmization(int[] nums,int target){
        int n = nums.length;
        boolean[] dp = new boolean[target+1];
        
        dp[0] = true;
        if(nums[0]<=target) dp[nums[0]] = true;

        for(int index=1;index<n;index++){
            boolean[] temp = new boolean[target+1];
            temp[0]=true;
            for(int sum=1;sum<=target;sum++){
                boolean not_take = dp[sum];
                boolean take = false;
                if(nums[index]<=sum) take = dp[sum-nums[index]];
                temp[sum] = take || not_take;
            }
            dp = temp;
        }
        return dp[target];
    }

    private boolean tabulation(int[] nums,int target){
        int n = nums.length;
        boolean[][] dp = new boolean[n][target+1];
        
        for(int i=0;i<n;i++) dp[i][0] = true;
        if(nums[0]<=target) dp[0][nums[0]] = true;

        for(int index=1;index<n;index++){
            for(int sum=1;sum<=target;sum++){
                boolean not_take = dp[index-1][sum];
                boolean take = false;
                if(nums[index]<=sum) take = dp[index-1][sum-nums[index]];
                dp[index][sum] = take || not_take;
            }
        }
        return dp[n-1][target];
    }

    private boolean recusrion(int index, int[] nums, int sum,int[][] dp){
        if(sum==0) return true;
        if(index<0) return false;
        
        if(dp[index][sum]!=-1) return dp[index][sum]==1;
        boolean not_take = recusrion(index-1, nums, sum,dp);
        boolean take = false;
        if(nums[index]<=sum) take = recusrion(index-1, nums, sum-nums[index],dp);
        boolean res = take || not_take;
        dp[index][sum] = res ? 1 : 0;
        return res;
    }
}