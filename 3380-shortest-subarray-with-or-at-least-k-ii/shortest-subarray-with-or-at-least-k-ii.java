class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int result = Integer.MAX_VALUE;
        int left = 0;
        int bitOr =0;
        int[] bits = new int[32];

        for(int right=0;right<nums.length;right++){
            updateBits(bits, nums[right], 1);
            bitOr = converttoInt(bits);

            while(left <= right && bitOr>=k){
                result = Math.min(result, right-left+1);
                updateBits(bits, nums[left], -1);
                bitOr = converttoInt(bits);
                left++;
            }
        }

        return result==Integer.MAX_VALUE ? -1 : result;

    }

    private int converttoInt(int[] bits){
        int num =0;
        for(int i=0;i<32;i++){
            if(bits[i]>0){
                num += (1<<i);
            }
        }
        return num;
    }

    private void updateBits(int[] bits, int num, int diff){
        for(int i=0;i<32;i++){
            if((num & (1<<i)) != 0){
                bits[i] += diff;
            }
        }
    }
}