class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        return helper(target, nums);
        // int l = 0;
        // int sum = 0;
        // int result = Integer.MAX_VALUE;

        // for(int r=0;r<nums.length;r++){
        //     sum += nums[r];
        //     while(l<=r && sum>=target){
        //         result = Math.min(result, r-l+1);
        //         sum -= nums[l++];
        //     }
        // }

        // return result == Integer.MAX_VALUE ? 0 : result;
    }

    // Trying follow up which is n log n
    private int helper(int target, int[] nums){
        int sum = 0;
        for(int i:nums) sum+=i;
        if(sum<target) return 0;
        int l = 1;
        int r = nums.length;
        int res = 0;

        while(l<=r){
            int mid = (l+r)/2;
            if(binarySearch(nums, target, mid)){
                res = mid;
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return res;
    }

    private boolean binarySearch(int[] nums, int target, int len){
        int sum = 0;
        int l = 0;
        int r =0;
        while(r<len){
            sum += nums[r++];
        }
        if(sum>=target) return true;
        while(r<nums.length){
            sum = sum + nums[r++] - nums[l++];
            if(sum>=target) return true;
        }
        return false;
    }
}