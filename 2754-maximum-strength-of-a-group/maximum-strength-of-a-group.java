class Solution {
    public long maxStrength(int[] nums) {
        int n = nums.length;
        
        // Base case: a single element is its own maximum strength
        if (n == 1) return nums[0];

        long product = 1;
        int countNeg = 0;
        int countPos = 0;
        int countZero = 0;
        int largestNeg = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num < 0) {
                countNeg++;
                product *= num;
                largestNeg = Math.max(largestNeg, num); // Track negative closest to 0
            } else if (num > 0) {
                countPos++;
                product *= num;
            } else {
                countZero++;
            }
        }

        // Edge Case 1: No positive numbers, and either:
        // - No negative numbers (all zeros, e.g., [0, 0, 0])
        // - Only one negative number and the rest are zeros (e.g., [-5, 0, 0])
        if (countPos == 0 && (countNeg == 0 || (countNeg == 1 && countZero > 0))) {
            return 0;
        }

        // Edge Case 2: Array has only one negative number and no zeros (e.g., [-5])
        // (Handled by the n == 1 check at the start)

        // If we have an odd number of negatives, divide out the largest negative
        if (countNeg % 2 != 0) {
            product /= largestNeg;
        }

        return product;
    }
}
