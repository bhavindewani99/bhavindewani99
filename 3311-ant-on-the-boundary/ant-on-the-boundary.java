class Solution {
    public int returnToBoundaryCount(int[] nums) {
        int sum =nums[0];
        int res = 0;
        for(int i=1;i<nums.length;i++){
            if(sum <0 && sum + nums[i]==0) res++;
            if(sum > 0 && sum + nums[i]==0) res++;
            sum+=nums[i];
        }
        return res;
    }
}