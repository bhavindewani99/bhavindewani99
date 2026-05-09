class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0, n = matchsticks.length;
        for (int x : matchsticks) sum += x;
        if (sum % 4 != 0) return false;

        // FIX 1: Sort the sticks.
        // We sort ascending then loop backwards to get the LARGEST sticks first.
        // Large sticks fail faster, which cuts off huge branches of the recursion tree.
        Arrays.sort(matchsticks);

        int[] sides = new int[4]; // Only need 4 buckets for the 4 sides
        return backtrack(n, sum / 4, matchsticks, sides, n - 1); // Start from the end (largest)
    }

    private boolean backtrack(int n, int targetSum, int[] matchsticks, int[] sides, int index) {
        if (index < 0) return true; // All sticks placed

        for (int i = 0; i < 4; i++) {
            // FIX 2: Deduplication Pruning
            // If this bucket is empty or has the same sum as a previous bucket we just tried,
            

            if (sides[i] + matchsticks[index] <= targetSum) {
                sides[i] += matchsticks[index];
                if (backtrack(n, targetSum, matchsticks, sides, index - 1)) return true;
                sides[i] -= matchsticks[index];
            }
        }
        return false;
    }
}
