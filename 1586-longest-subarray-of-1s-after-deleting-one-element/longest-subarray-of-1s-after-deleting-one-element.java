class Solution {
    public int longestSubarray(int[] nums) {

        // 2 pointers approach where we increase the window including one zero
        int zeroIndex = -1;
        int left = 0;
        int result = 0;

        for(int right =0;right<nums.length;right++){
            if(nums[right]==0){
                if(zeroIndex!=-1){
                    left = zeroIndex + 1;
                    zeroIndex = right;
                }else{
                    zeroIndex = right;
                }
            }
            result = Math.max(result, right-left);
        }
        return result;
    }

    // brute force approach where we count number of ones form both the sides
    private int bruteForce(int[] nums){
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