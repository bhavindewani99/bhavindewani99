class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {

        int n = nums.length;
        long[] prefix = new long[n + 1];
        long sum = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            prefix[i + 1] = sum;
        }

        // ✅ fix: use correct order of lower, upper and full range 0..n
        return mergeSort(nums, lower, upper, 0, n, prefix);
    }

    private int mergeSort(int[] nums, int lower, int upper, int left, int right, long[] prefix) {
        if (left >= right) return 0;

        int mid = left + (right - left) / 2;

        int count = mergeSort(nums, lower, upper, left, mid, prefix)
                  + mergeSort(nums, lower, upper, mid + 1, right, prefix);

        int l = mid + 1, r = mid + 1;

        // ✅ correct two-pointer logic
        for (int i = left; i <= mid; i++) {
            while (l <= right && prefix[l] - prefix[i] < lower) l++;
            while (r <= right && prefix[r] - prefix[i] <= upper) r++;
            count += r - l;
        }

        // ✅ your original merge logic preserved
        merge(prefix, left, mid, right);
        return count;
    }

    private void merge(long[] prefix, int left, int mid, int right) {
        int i = left, j = mid + 1, k = 0;
        long[] temp = new long[right - left + 1];

        while (i <= mid && j <= right) {
            if (prefix[i] <= prefix[j]) {
                temp[k++] = prefix[i++];
            } else {
                temp[k++] = prefix[j++];
            }
        }

        while (i <= mid) temp[k++] = prefix[i++];
        while (j <= right) temp[k++] = prefix[j++];

        // ✅ keep your manual copy
        for (i = 0; i < temp.length; i++) {
            prefix[left + i] = temp[i];
        }
    }
}
