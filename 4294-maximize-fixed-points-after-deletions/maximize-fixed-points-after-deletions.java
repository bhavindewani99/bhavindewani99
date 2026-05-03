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

        // Sort pairs: primary key (i - nums[i]), secondary key (nums[i])
        Collections.sort(p, (a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        List<Integer> list = new ArrayList<>();
        for (int[] pair : p) {
            int val = pair[1];
            int idx = lowerBound(list, val);

            if (idx < list.size()) {
                // If an element >= val exists, replace it (equivalent to erase + insert)
                list.set(idx, val);
            } else {
                // Otherwise, extend the sequence
                list.add(val);
            }
        }

        return list.size();
    }

    // Custom binary search to find the first index where list.get(index) >= target
    private int lowerBound(List<Integer> list, int target) {
        int low = 0, high = list.size();
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid) >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
