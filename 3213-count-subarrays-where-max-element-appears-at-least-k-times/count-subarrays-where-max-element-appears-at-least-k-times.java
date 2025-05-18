class Solution {
    public long countSubarrays(int[] nums, int k) {
        
        long result = 0;
        int maxElement = 0, n = nums.length, left = 0, currCount = 0;

        for(int num : nums) maxElement = Math.max(num, maxElement);

        for(int right =0;right<n;right++){
            if(nums[right] == maxElement) currCount++;

            while(currCount == k){
                result += (n - right);
                if(nums[left] == maxElement) currCount--;
                left++;
            }
        }

        return result;
    }
}