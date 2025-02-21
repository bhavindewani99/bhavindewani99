class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        int last = -1000;

        for(int i : nums){
            if(i!=last){
                nums[index++] = i;
            }
            last = i;
        }
        return index;
    }
}