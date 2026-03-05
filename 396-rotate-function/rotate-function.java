class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        long sum = 0;
        long f = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            f += (long) i * nums[i];
        }

        long best = f;

        // k = 1..n-1
        for (int k = 1; k < n; k++) {
            // element moved to front by this clockwise rotation
            long moved = nums[n - k];
            f = f + sum - (long) n * moved;
            if (f > best) best = f;
        }

        return (int) best;
    }
}