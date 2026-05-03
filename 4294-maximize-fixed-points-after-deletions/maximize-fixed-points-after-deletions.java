import java.util.*;

class Solution {
    public int maxFixedPoints(int[] nums) {
        int n = nums.length;
        List<int[]> candidates = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (nums[i] <= i) {
                // [value, deletions]
                candidates.add(new int[]{nums[i], i - nums[i]});
            }
        }

        // Sort by value ascending. 
        // If values are equal, sort deletions DESCENDING.
        // This ensures we only pick one instance of any specific value.
        candidates.sort((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(b[1], a[1]);
        });

        List<Integer> tails = new ArrayList<>();
        for (int[] c : candidates) {
            int d = c[1];
            // Longest Non-Decreasing Subsequence on deletions
            if (tails.isEmpty() || d >= tails.get(tails.size() - 1)) {
                tails.add(d);
            } else {
                int idx = firstStrictlyGreater(tails, d);
                tails.set(idx, d);
            }
        }

        return tails.size();
    }

    private int firstStrictlyGreater(List<Integer> tails, int target) {
        int low = 0, high = tails.size() - 1;
        int ans = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (tails.get(mid) > target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
