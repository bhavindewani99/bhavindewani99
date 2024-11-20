class Solution {
    public boolean predictTheWinner(int[] nums) {
        return recursion(0, nums.length - 1, nums, 1) >= 0;
    }

    private int recursion(int i, int j, int[] nums, int turn) {
        if (i > j) return 0; 

        if (turn == 1) {
            int takeLeft = nums[i] + recursion(i + 1, j, nums, -1);
            int takeRight = nums[j] + recursion(i, j - 1, nums, -1);
            return Math.max(takeLeft, takeRight);
        } else {
            int takeLeft = -nums[i] + recursion(i + 1, j, nums, 1);
            int takeRight = -nums[j] + recursion(i, j - 1, nums, 1);
            return Math.min(takeLeft, takeRight);
        }
    }
}
