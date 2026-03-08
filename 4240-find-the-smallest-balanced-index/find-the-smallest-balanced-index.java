class Solution {
    public int smallestBalancedIndex(int[] nums) {
        int n = nums.length;
        long tSum = 0;
        for (int x : nums) tSum += x;

        long rightProd = 1;
        long leftSum = tSum;
        int ans = -1;

        for (int i = n - 1; i >= 0; i--) {
            leftSum -= nums[i];
            
            if (leftSum == rightProd) {
                ans = i;
            } else if (leftSum < rightProd) {
                break;
            }

            rightProd *= nums[i];
        }

        return ans;
    }
}