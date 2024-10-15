class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        int[] maxiArr = new int[n];
        int maxi = nums[n - 1];
        int res = 0;

        maxiArr[n - 1] = maxi;

        // Fill maxiArr with the maximum values from the right
        for (int i = n - 2; i >= 0; i--) {
            maxi = Math.max(maxi, nums[i]);
            maxiArr[i] = maxi;
        }

        int l = 0;

        // Iterate over the array and find the widest ramp
        for (int r = 0; r < n; r++) {
            while (l < r && nums[l] > maxiArr[r]) {
                l++;
            }
            res = Math.max(res, r - l);
        }

        return res;
    }
}
