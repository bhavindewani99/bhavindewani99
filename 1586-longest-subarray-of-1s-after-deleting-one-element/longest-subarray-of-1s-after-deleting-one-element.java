class Solution {
    public int longestSubarray(int[] nums) {

        int n = nums.length;
        int[] count = new int[n];
        int curr = 0;
        boolean containsZero = false;
        int result = 0;

        for(int i=0;i<n;i++){
            if(nums[i]==1) curr++;
            else curr = 0;
            count[i] = curr;
            if(nums[i]==0) containsZero = true;
        }

        if(containsZero==false) return n-1;

        curr = 0;
        for(int i=n-1;i>=0;i--){
            if(nums[i]==1) curr++;
            else curr = 0;
            count[i] = Math.max(count[i], curr);
        }

        for(int i=0;i<n;i++){
            if(nums[i]==0){
                int currMax = 0;
                if(i-1>=0) currMax = count[i-1];
                if(i+1<n) currMax += count[i+1];
                result = Math.max(result, currMax);
            }
        }

        return result;
    }
}