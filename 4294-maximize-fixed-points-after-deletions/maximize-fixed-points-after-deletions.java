import java.util.*;

class Solution {
    public int maxFixedPoints(int[] nums) {
        int n = nums.length;
        List<int[]> p = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (i >= nums[i]) {
                p.add(new int[]{i - nums[i], nums[i]});
            }
        }

        // Sort: primary key i-nums[i], secondary key nums[i]
        Collections.sort(p, (a, b) ->  a[0] - b[0]);

        List<Integer> list = new ArrayList<>();
        for (int[] pair : p) {
            int val = pair[1];
            int idx = lowerBound(list, val);

            // If an index was found, replace; otherwise, append
            if (idx != -1) {
                list.set(idx, val);
            } else {
                list.add(val);
            }
        }

        return list.size();
    }

    private int lowerBound(List<Integer> list, int target) {
        int low = 0;
        int high = list.size() - 1;
        int ans = -1; // Stores the index of the first element >= target

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (list.get(mid) >= target) {
                ans = mid;    // Found a potential candidate
                high = mid - 1; // Look for a smaller index on the left
            } else {
                low = mid + 1;  // Look on the right
            }
        }
        return ans;
    }
}
