class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n<=1) return nums[0];
        return tabulation(n, nums);
        // int[] dp = new int[n];
        // Arrays.fill(dp,-1);
        // return recursion(nums.length-1,nums,dp);
    }

    private int tabulation(int n, int[] nums){
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i=2;i<n;i++){
            int take = Integer.MIN_VALUE;
            //if(i-2>=0)
            take = dp[i-2] + nums[i];
            int not_take = dp[i-1];
            dp[i] = Math.max(take,not_take);
        }
        return dp[n-1];
    }

    private int recursion(int index, int[] nums,int[] dp){
        if(index<0) return 0;
        if(index==0) return nums[index];
        if(dp[index]!=-1) return dp[index];
        int take = recursion(index-2, nums,dp) + nums[index];
        int not_take = recursion(index-1, nums,dp);
        return dp[index]=Math.max(take,not_take);
    }
}