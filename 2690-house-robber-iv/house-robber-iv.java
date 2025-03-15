class Solution {
    public int minCapability(int[] nums, int k) {
        
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE, result = 0;

        for(int i : nums){
            low = Math.min(low, i);
            high = Math.max(high, i);
        }

        while (low<=high) {
            int mid = low + (high-low)/2;
            if(possible(nums, mid, k)==true){
                result = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return result;
    }

    private boolean possible(int[] nums, int maxValue, int k){
        int canRob = 0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]<=maxValue){
                canRob++;
                i++;
            }
        }

        return canRob >= k;
    }
}