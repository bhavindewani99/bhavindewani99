class Solution {
    public boolean predictTheWinner(int[] nums) {
        int[][] memo = new int[nums.length][nums.length]; // Memoization table
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                memo[i][j] = Integer.MIN_VALUE; // Initialize with a sentinel value
            }
        }
        int totalScore = 0;
        for (int num : nums) {
            totalScore += num; // Compute the total sum of all elements
        }
        int player1Score = recursion(0, nums.length - 1, nums, 1, memo);
        return player1Score >= (totalScore - player1Score);
    }

    private int recursion(int i, int j, int[] nums, int turn, int[][] memo) {
        if (i > j) return 0; // Base case: no elements left to pick

        if (memo[i][j] != Integer.MIN_VALUE) {
            return memo[i][j]; // Return cached result if already computed
        }

        if (turn == 1) {
            // Player 1's turn: maximize their total score
            int pickLeft = nums[i] + recursion(i + 1, j, nums, 0, memo);
            int pickRight = nums[j] + recursion(i, j - 1, nums, 0, memo);
            memo[i][j] = Math.max(pickLeft, pickRight);
        } else {
            // Player 2's turn: minimize Player 1's score by taking the rest
            int pickLeft = recursion(i + 1, j, nums, 1, memo);
            int pickRight = recursion(i, j - 1, nums, 1, memo);
            memo[i][j] = Math.min(pickLeft, pickRight);
        }

        return memo[i][j];
    }
}
