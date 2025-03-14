class Solution {
    public int[] applyOperations(int[] nums) {
        
        int n = nums.length;
        int[] result = new int[n];
        int left = 0;

        for(int i=0;i<n;i++){
            if(nums[i]==0) continue;
            if(i==n-1 || nums[i]!=nums[i+1]) result[left] = nums[i];
            else result[left] = nums[i++]*2;
            left++;
        }
        return result;
    }
}