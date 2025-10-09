class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] prefix = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        return mergeSortCount(prefix, 0, prefix.length - 1, lower, upper);
    }

    private int mergeSortCount(long[] prefix, int left, int right, int lower, int upper) {
        if (left >= right) return 0;

        int mid = left + (right - left) / 2;
        int count = mergeSortCount(prefix, left, mid, lower, upper) 
                  + mergeSortCount(prefix, mid + 1, right, lower, upper);

        // count cross ranges
        int l = mid + 1, r = mid + 1;
        for (int i = left; i <= mid; i++) {
            while (l <= right && prefix[l] - prefix[i] < lower) l++;
            while (r <= right && prefix[r] - prefix[i] <= upper) r++;
            count += r - l;
        }

        // merge step (to keep prefix sorted)
        merge(prefix, left, mid, right);
        return count;
    }

    private void merge(long[] arr, int left, int mid, int right) {
        long[] temp = new long[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) temp[k++] = arr[i++];
            else temp[k++] = arr[j++];
        }
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];
        System.arraycopy(temp, 0, arr, left, temp.length);
    }
}