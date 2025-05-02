class Solution {
    public int minIncrementForUnique(int[] nums) {
        
        Arrays.sort(nums);
        int operations = 0, next = nums[0]+1;

        for(int i=1;i<nums.length;i++){
            int curr = nums[i];
            if(curr <= next) {
                operations += (next-curr);
                next++;
            }else{
                next = nums[i] + 1;
            }
        }

        return operations;
    }
}