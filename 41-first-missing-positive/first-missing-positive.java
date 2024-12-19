class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Removing useless values like negative to 0
        for(int i=0;i<n;i++){
            if(nums[i]<0) nums[i]=0;
        }

        // Marking the appeared values
        for(int i=0;i<n;i++){
            int val = Math.abs(nums[i]);
            if(1<=val && val<=n){
                if(nums[val-1]>0) nums[val-1] = -1 * nums[val-1];
                else if(nums[val-1]==0) nums[val-1] = -1 * (n+1);
            }
        }
        
        // Finding the answer
        for(int i=1;i<=n;i++){
            if(nums[i-1]>=0) return i;
        }
        return n+1;
    }
}