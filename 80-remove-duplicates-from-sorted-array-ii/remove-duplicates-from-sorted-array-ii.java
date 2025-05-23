class Solution {
    public int removeDuplicates(int[] nums) {
        
        int index = 0;

        for(int i=0;i<nums.length;i++){
            if(index<=1 || (index>=2 && nums[index-2]!=nums[i])){
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}