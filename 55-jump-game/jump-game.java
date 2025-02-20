class Solution {
    public boolean canJump(int[] nums) {
        
        int maxIndex = nums[0];

        for(int i=1;i<nums.length;i++){
            if(i>maxIndex) return false;
            maxIndex = Math.max(maxIndex, i + nums[i]);
        }
        return true;
    }
}