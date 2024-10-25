class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n-1;
        while(l<=r){
            int mid = (l+r)/2;
            if((mid==n-1 || nums[mid]>nums[mid+1]) && (mid==0 || nums[mid]>nums[mid-1])){
                return mid;
            }else if (mid!=n-1 && nums[mid]<nums[mid+1]){
                l=mid+1;
            }else{
                r = mid-1;
            }
        }
        return -1;
    }
}