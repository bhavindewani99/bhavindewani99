class Solution {
    public int subsetXORSum(int[] nums) {
        
        return recursion(0, nums, 0);
    }


    private int recursion(int index, int[] nums, int xor){
        if(index==nums.length) return xor;

        int not_take = recursion(index+1, nums, xor);

        //xor = xor ^ nums[index];
        int take = recursion(index+1, nums,xor  ^ nums[index]);

        return take + not_take;
    }
}



