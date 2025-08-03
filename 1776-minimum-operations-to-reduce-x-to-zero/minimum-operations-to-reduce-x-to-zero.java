class Solution {
    public int minOperations(int[] nums, int x) {
        
        int totalSum = 0;
        for(int num : nums) totalSum += num;
        int requiredSum = totalSum - x;
        int maxLength = -1;
        int left = 0;
        int currSum = 0;

        for(int i=0;i<nums.length;i++){
            currSum += nums[i];
            while (currSum > requiredSum && left<=i) {
                currSum -= nums[left++];
            }
            if(currSum == requiredSum){
                maxLength = Math.max(maxLength, i-left + 1);
            }
        }
        return maxLength == -1 ? -1 : nums.length - maxLength;
    }
}