class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return 1;

        int prev_diff = nums[1] - nums[0];
        int count = (prev_diff != 0) ? 2 : 1;

        for (int i = 2; i < n; i++) {
            int curr_diff = nums[i] - nums[i - 1];

            if ((curr_diff > 0 && prev_diff <= 0) ||
                (curr_diff < 0 && prev_diff >= 0)) {
                count++;
                prev_diff = curr_diff;
            }
        }
        return count;
    }
}
