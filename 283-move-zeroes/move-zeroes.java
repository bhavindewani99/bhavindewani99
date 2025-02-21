class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0, i=0;

        while(i<nums.length){
            if(nums[i]!=0){
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                index++;
            }
            i++;
        }
        
    }
}