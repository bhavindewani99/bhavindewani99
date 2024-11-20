import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean predictTheWinner(int[] nums) {
        int[][] memo = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                memo[i][j] = Integer.MIN_VALUE;
            }
        }
        return recursion(0, nums.length - 1, nums, 1, memo) >= 0;
    }

    private int recursion(int i, int j, int[] nums, int turn, int[][] memo) {
        if (i > j) return 0;

        if (memo[i][j] != Integer.MIN_VALUE) {
            return memo[i][j];
        }

        if (turn == 1) {
            // Player 1's turn: maximize score difference
            int takeLeft = nums[i] + recursion(i + 1, j, nums, -1, memo);
            int takeRight = nums[j] + recursion(i, j - 1, nums, -1, memo);
            memo[i][j] = Math.max(takeLeft, takeRight);
        } else {
            // Player 2's turn: minimize score difference
            int takeLeft = -nums[i] + recursion(i + 1, j, nums, 1, memo);
            int takeRight = -nums[j] + recursion(i, j - 1, nums, 1, memo);
            memo[i][j] = Math.min(takeLeft, takeRight);
        }

        return memo[i][j];
    }
}
