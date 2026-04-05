class Solution {
    public long minIncrease(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0;

        // dp[i] stores the best (max special, min cost) result considering indices up to i
        Pair[] dp = new Pair[n];
        for (int i = 0; i < n; i++) dp[i] = new Pair(0, 0);

        for (int i = 1; i < n - 1; i++) {
            // Option 1: Current index i is NOT special (take best from i-1)
            Pair notTake = dp[i - 1];

            // Option 2: Current index i IS special (take best from i-2 + current cost)
            long currentCost = Math.max(0L, Math.max(nums[i - 1], nums[i + 1]) + 1L - nums[i]);
            long totalSpecial = 1 + (i >= 2 ? dp[i - 2].special : 0);
            long totalCost = currentCost + (i >= 2 ? dp[i - 2].cost : 0);
            
            Pair take = new Pair(totalSpecial, totalCost);
            
            // Choose the better option
            dp[i] = take.isBetterThan(notTake) ? take : notTake;
        }

        // The answer is at n-2 because the last element can't be special
        return dp[n - 2].cost;
    }

    class Pair {
        long special, cost;

        Pair(long s, long c) {
            this.special = s;
            this.cost = c;
        }

        // Returns true if 'this' has more special indices OR 
        // same special indices with a lower cost.
        boolean isBetterThan(Pair other) {
            if (this.special != other.special) {
                return this.special > other.special;
            }
            return this.cost <= other.cost;
        }
    }
}
