class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length==1) return true;
        int maxIndex = nums[0];
        if(nums[0]==0) return false;

        for(int i=1;i<nums.length;i++){
            if(i>maxIndex) return false;
            maxIndex = Math.max(maxIndex, i + nums[i]);
            if(maxIndex>=nums.length-1) return true;
        }
        return false;
    }
}