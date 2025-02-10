class Solution {
    public int missingElement(int[] nums, int k) {
        int low = 0, high = nums.length - 1;
        int start = nums[0];

        while (low <= high) {
            int mid = (low + high) / 2;
            int missing = nums[mid] - start - mid; // Correct missing count

            if (missing >= k) {
                high = mid - 1; // Move left
            } else {
                low = mid + 1; // Move right
            }
        }

        // Now `high` is the last index before we exceed `k` missing numbers
        int missingBefore = nums[high] - start - high;
        return nums[high] + (k - missingBefore);
    }
}
