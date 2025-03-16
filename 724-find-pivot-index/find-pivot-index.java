class Solution {
    public int pivotIndex(int[] nums) {
        
        int index = -1, n=nums.length, sum =0, leftSum = 0;

        for(int i : nums) sum +=i;

        for(int i=0;i<n;i++){
            int rightSum = sum - leftSum - nums[i];
            if(leftSum == rightSum) return i;
            leftSum += nums[i];
        }
        return -1;
    }
}