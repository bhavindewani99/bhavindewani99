class Solution {
    public boolean predictTheWinner(int[] nums) {
        int[][] memo = new int[nums.length][nums.length]; // Memoization table
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                memo[i][j] = Integer.MIN_VALUE; // Initialize with a sentinel value
            }
        }

        // Total sum of elements to calculate Player 2's score
        int totalScore = 0;
        for (int num : nums) {
            totalScore += num;
        }

        // Player 1's maximum score
        int player1Score = getMaxScore(nums, 0, nums.length - 1, memo);

        // Player 1 wins if their score is at least half of the total
        return player1Score >= totalScore - player1Score;
    }

    private int getMaxScore(int[] nums, int i, int j, int[][] memo) {
        if (i > j) return 0; // Base case: no elements left to pick

        if (memo[i][j] != Integer.MIN_VALUE) {
            return memo[i][j]; // Return cached result
        }

        // Player 1 picks either the left or the right element, and Player 2 minimizes Player 1's future score
        int pickLeft = nums[i] + Math.min(getMaxScore(nums, i + 2, j, memo), getMaxScore(nums, i + 1, j - 1, memo));
        int pickRight = nums[j] + Math.min(getMaxScore(nums, i, j - 2, memo), getMaxScore(nums, i + 1, j - 1, memo));

        // Store the maximum score Player 1 can achieve for the current range
        memo[i][j] = Math.max(pickLeft, pickRight);

        return memo[i][j];
    }
}
