class Solution {
    public boolean isMonotonic(int[] nums) {
        int prev = nums[0];
        boolean increasing = true;
        boolean decided = false;

        for(int i=1;i<nums.length;i++){
            
            if(nums[i]==prev) continue;
            if(decided==false){
                increasing = prev < nums[i] ? true : false;
                decided = true;
            }else{
                if(increasing && prev > nums[i]) return false;
                else if(!increasing && prev < nums[i]) return false;
            }
            prev = nums[i];
        }
        return true;
    }
}