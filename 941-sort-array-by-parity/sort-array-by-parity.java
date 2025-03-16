class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int right=0;
        
        while(right <nums.length){
            if(nums[right]%2==0){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
            right++;
        }
        return nums;
    }
}