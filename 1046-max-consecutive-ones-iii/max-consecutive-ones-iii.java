class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int start = 0;
        int res =0;
        for(int i=0;i<n;i++){
            if(nums[i]==0) k--;
            while(k<0){
                if(nums[start]==0){
                    k++;
                }
                start++;
            }
            res = Math.max(res, i-start+1);
        }
        return res;
    }
}