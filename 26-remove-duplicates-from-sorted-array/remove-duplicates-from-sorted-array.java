class Solution {
    public int removeDuplicates(int[] nums) {
        int curr = nums[0];
        int point =1;
        for (int i=1;i<nums.length;i++){
            if (nums[i]!=curr){
                nums[point]=nums[i];
                curr=nums[i];
                point++;
            }
        }
        return point;
        
    }
}