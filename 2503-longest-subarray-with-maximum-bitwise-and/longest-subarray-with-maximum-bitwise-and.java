class Solution {
    public int longestSubarray(int[] nums) {
        
        int maxElement = Integer.MIN_VALUE;
        for(int num : nums) maxElement = Math.max(maxElement, num);
        int currLen = 0, maxLen = 1;

        for(int num :  nums){
            if(maxElement == num){
                currLen++;
            }else{
                currLen = 0;
            }
            maxLen = Math.max(maxLen, currLen);
        }
        return maxLen;
    }
}