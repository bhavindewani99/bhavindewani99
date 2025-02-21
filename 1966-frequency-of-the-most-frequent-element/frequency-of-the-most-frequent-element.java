class Solution {
    public int maxFrequency(int[] nums, int k) {
        
        // We use two pointers left and right
        // We try to make every element as value at right pointers
        // So value[r]*windowLength <= totalSum + k
        // Because we can check how much we have and after adding k till what we can make 

        int result = 0, left =0, right =0;
        long totalSum = 0;
        Arrays.sort(nums);

        while(right<nums.length){
            totalSum += nums[right];

            while((long) nums[right]*(right -left +1) > totalSum + k){
                totalSum -= nums[left++];
            }
            result = Math.max(result, right - left + 1);
            right++;
        }
        return result;
    }
}