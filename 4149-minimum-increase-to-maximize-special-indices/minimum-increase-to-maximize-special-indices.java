class Solution {
    public long minIncrease(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0;

        Pair[] dp = new Pair[n];
        for (int i = 0; i < n; i++) dp[i] = new Pair(0, 0);

        for (int i = 1; i < n - 1; i++) {
            // Option 1: Don't make current index i special
            Pair notTake = dp[i - 1];

            // Option 2: Make current index i special
            long currentCost = Math.max(0, Math.max(nums[i - 1], nums[i + 1]) + 1 - nums[i]);
            long totalSpecial = 1;
            long totalCost = currentCost;

            if (i >= 2) {
                totalSpecial += dp[i - 2].special;
                totalCost += dp[i - 2].cost;
            }

            dp[i] = giveBest(new Pair(totalSpecial, totalCost), notTake);
        }

        return dp[n - 2].cost;
    }

    private Pair giveBest(Pair a, Pair b) {
        if (a.special > b.special) return a;
        if (b.special > a.special) return b;
        return (a.cost <= b.cost) ? a : b;
    }

    class Pair {
        long special, cost;
        Pair(long s, long c) {
            this.special = s;
            this.cost = c;
        }
    }
}
