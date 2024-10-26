class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1,-1};
        if(nums.length==0) return result;
        int x = findFirst(nums, target,true);
        if(x==-1 || nums[x]!=target) return result;
        result[0] = x;
        result[1] = findFirst(nums, target, false);
        return result;

    }

    private int findFirst(int[] nums,int target,boolean flag){
        int res = -1;
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(flag && nums[mid]>=target){
                res = mid;
                high = mid-1;
            }else if(!flag && nums[mid]<=target){
                res = mid;
                low=mid+1;
            }
            else{
                if(flag)
                low = mid+1;
                else
                high = mid-1;
            }
        }
        return res;
    }
}