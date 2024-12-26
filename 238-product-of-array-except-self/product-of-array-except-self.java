class Solution {
    public int[] productExceptSelf(int[] nums) {
        int zeros = 0;
        long multi = 1;
        int[] result = new int[nums.length];
        for(int i:nums){
            if(i==0){
                if(zeros==1) return result;
                zeros++;
            }else{
                multi *= i;
            }
        }
        if(zeros>0){
            for(int i=0;i<nums.length;i++) {
                if(nums[i]==0) result[i] = (int) multi;
            }
        }else{
            for(int i=0;i<nums.length;i++){
                result[i] = (int) (multi/nums[i]);
            }
        }
        return result;
    }
}