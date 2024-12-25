class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int maxi = nums[0], mini = nums[0];
        int total = 0, currMax = 0, currMin = 0;

        for(int i : nums){
            currMax = Math.max(currMax + i, i);
            currMin = Math.min(currMin + i, i);

            total += i;
            maxi = Math.max(maxi, currMax);
            mini = Math.min(mini, currMin);
        } 

        if(maxi<0) return maxi;

        return Math.max(maxi, total - mini);
    }
}