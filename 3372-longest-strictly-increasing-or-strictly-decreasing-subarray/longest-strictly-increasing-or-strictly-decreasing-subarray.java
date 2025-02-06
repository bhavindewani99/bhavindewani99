class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        
        int result = 0;
        int increasing = 1, decreasing = 1;
        int last = nums[0];

        for(int i : nums){
            if(i>last) increasing++;
            else increasing = 1;
            last = i;
            result = Math.max(increasing, result);
        }
        last = nums[0];
        for(int i : nums){
            if(i<last) decreasing++;
            else decreasing = 1;
            last = i;
            result = Math.max(result, decreasing);
        }
        return result;
    }
}