class Solution {
    public void moveZeroes(int[] nums) {
        int index=0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]!=0){
                if (i != index) {
                    nums[index] = nums[i];
                    nums[i] = 0;
                }
                index++;
            }
            
        }
        // for(;index<n;index++){
        //     nums[index]=0;
        // }
    }
}