class Solution {
    public int longestNiceSubarray(int[] nums) {
        
        // We can use two pointers approach we check before increasing the window we have common bits set
        // If yes the we shrink the window by unsetting the bits at left pointer we can unset the bits using xor operation because it turns value into zero if we di with same numbers

        int curr = 0;
        int left = 0;
        int result = 0;

        for(int right=0; right<nums.length;right++){
            //Checking if there are any set bits then we remove it first
            while ((curr & nums[right]) != 0) {
                curr = curr ^ nums[left++];
            }
            result = Math.max(result, right - left + 1);
            curr = curr | nums[right]; // increasing window by setting bits
        }
        return result;
    }
}