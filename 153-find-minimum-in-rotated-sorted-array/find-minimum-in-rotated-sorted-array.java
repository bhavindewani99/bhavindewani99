class Solution {
    public int findMin(int[] nums) {
        int res = nums[0];
        int l = 0;
        int h = nums.length-1;

        while(l<=h){
            int mid = (l+h)/2;
            res = Math.min(res,nums[mid]);
            if(nums[mid]<nums[h]){
                h = mid-1;
            }else{
                l = mid+1;
            }
        }

        return res;
    }
}