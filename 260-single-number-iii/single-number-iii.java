class Solution {
    public int[] singleNumber(int[] nums) {
        
        int xor = 0, a =0 , b=0;

        for(int num : nums) xor ^= num;
        int diff_bit = 1; 

        while((diff_bit & xor) == 0){ // find the first set bit to distribute the elements
            diff_bit = diff_bit << 1;
        }

        for(int num : nums){
            if((diff_bit & num) != 0) a ^= num;
            else b ^= num;
        }

        return new int[]{a,b};
    }
}