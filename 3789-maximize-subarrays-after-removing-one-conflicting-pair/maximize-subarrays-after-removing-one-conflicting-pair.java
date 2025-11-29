class Solution {
    public long maxSubarrays(int n, int[][] conflictingPairs) {

        int m = conflictingPairs.length;

        // Ensure each pair is ordered (start ≤ end)
        for (int i = 0; i < m; i++) {
            if (conflictingPairs[i][0] > conflictingPairs[i][1]) {
                int temp = conflictingPairs[i][0];
                conflictingPairs[i][0] = conflictingPairs[i][1];
                conflictingPairs[i][1] = temp;
            }
        }

        // Sort by end-point
        Arrays.sort(conflictingPairs, (a, b) -> Integer.compare(a[1], b[1]));

        long blocked = 0L;
        long profit = 0L;
        long maxProfit = 0L;
        long max1 = 0L;
        long max2 = 0L;

        for (int i = 0; i < m; i++) {

            long start = conflictingPairs[i][0];
            long end = conflictingPairs[i][1];

            long bottom = (i < m - 1 ? conflictingPairs[i + 1][1] : (long) n + 1);
            long gap = bottom - end;

            // Update max1 and max2
            if (start > max1) {
                max2 = max1;
                max1 = start;
                profit = 0L;
            } else if (start > max2) {
                max2 = start;
            }

            // Accumulate profit
            profit += (max1 - max2) * gap;
            if (profit > maxProfit) {
                maxProfit = profit;
            }

            // Add blocked
            blocked += max1 * gap;
        }

        long totalSubarrays = (long) n * (n + 1) / 2;
        return totalSubarrays - blocked + maxProfit;
    }
}
