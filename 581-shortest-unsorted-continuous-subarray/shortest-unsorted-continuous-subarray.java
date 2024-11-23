class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
        if(n==1) return 0;

        for(int i=0;i<n;i++){
            if(i==0){
                if(nums[i]>nums[i+1]){
                    mini = Math.min(mini, nums[i]);
                    maxi = Math.max(maxi, nums[i]);
                }
            }else if(i==n-1){
                if(nums[i-1]>nums[i]){
                    mini = Math.min(mini, nums[i]);
                    maxi = Math.max(maxi, nums[i]);
                }
            }else {
                if(nums[i]>nums[i+1] || nums[i-1]>nums[i]){
                    mini = Math.min(mini, nums[i]);
                    maxi = Math.max(maxi, nums[i]);
                }
            }
        }
        if(mini==Integer.MAX_VALUE && maxi == Integer.MIN_VALUE) return 0;
        int l=0, r=0;
        for(;l<n;l++){
            if(nums[l]<=mini) continue;
            else break;
        }
        for(r=n-1;r>=0;r--){
            if(nums[r]>=maxi) continue;
            else break;
        }

        return r - l + 1;

    }
}