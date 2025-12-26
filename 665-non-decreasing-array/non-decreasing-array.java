class Solution {
    public boolean checkPossibility(int[] nums) {
        int changes = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                changes++;
                if (changes > 1) return false;

                // decide whether to adjust nums[i] or nums[i+1]
                if (i == 0 || nums[i - 1] <= nums[i + 1]) {
                    // lower nums[i]
                    nums[i] = nums[i + 1];
                } else {
                    // raise nums[i+1]
                    nums[i + 1] = nums[i];
                }
            }
        }
        return true;
    }
}
