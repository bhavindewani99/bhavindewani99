import java.util.Random;

class Solution {
    private final Random rand = new Random();

    public void wiggleSort(int[] nums) {
        int n = nums.length;
        if (n <= 1) return;

        // 1) Find lower median in O(n) average time
        int median = quickSelect(nums, 0, n - 1, (n - 1) / 2);

        // 2) 3-way partition using virtual indexing (Dutch National Flag)
        int left = 0, i = 0, right = n - 1;

        while (i <= right) {
            int vi = newIndex(i, n);

            if (nums[vi] > median) {
                int vl = newIndex(left, n);
                swap(nums, vi, vl);
                left++;
                i++;
            } else if (nums[vi] < median) {
                int vr = newIndex(right, n);
                swap(nums, vi, vr);
                right--;
                // do NOT increment i here (need to re-check swapped in value)
            } else {
                i++;
            }
        }
    }

    // Maps virtual position i -> real index in nums
    // Visits odd indices first, then even indices
    private int newIndex(int i, int n) {
        return (1 + 2 * i) % (n | 1);
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    // Returns the k-th smallest element in nums[lo..hi] (0-based k)
    private int quickSelect(int[] nums, int lo, int hi, int k) {
        while (lo <= hi) {
            int pivotIndex = lo + rand.nextInt(hi - lo + 1);
            int p = partition(nums, lo, hi, pivotIndex);

            if (p == k) return nums[p];
            if (p < k) lo = p + 1;
            else hi = p - 1;
        }
        // Should never reach here for valid input
        return -1;
    }

    // Standard Lomuto partition around pivot value:
    // after partition: nums[lo..p-1] < pivot, nums[p] == pivot, nums[p+1..hi] >= pivot
    private int partition(int[] nums, int lo, int hi, int pivotIndex) {
        int pivotVal = nums[pivotIndex];
        swap(nums, pivotIndex, hi);

        int store = lo;
        for (int j = lo; j < hi; j++) {
            if (nums[j] < pivotVal) {
                swap(nums, store, j);
                store++;
            }
        }
        swap(nums, store, hi);
        return store;
    }
}
