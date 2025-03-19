class Solution {
    public int removeDuplicates(int[] nums) {
        
        int index = 0, last = Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){
            if(nums[i]!=last){
                nums[index++] = nums[i];
            }else if(index==1 || (index>=2 && nums[index-2]!=nums[i])){
                nums[index++] = nums[i];
            }
            last = nums[i];
        }
        return index;
    }
}