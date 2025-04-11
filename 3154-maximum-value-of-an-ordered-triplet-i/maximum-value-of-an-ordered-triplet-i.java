class Solution {
    public long maximumTripletValue(int[] nums) {
        long result = 0, difference = 0, maximum =0;

        for(int i=0;i<nums.length;i++){
            result = Math.max(result, difference * nums[i]);
            difference = Math.max(difference, Math.max(0, maximum - nums[i]));
            maximum = Math.max(maximum, nums[i]);
        }

        return result;
    }
}

// 12
// 6
