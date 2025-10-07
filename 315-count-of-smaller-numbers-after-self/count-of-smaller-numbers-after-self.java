class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        List<Pair> pairs = new ArrayList<>();
        Integer[] result = new Integer[n];
        Arrays.fill(result, 0);

        for (int i = 0; i < n; i++) {
            pairs.add(new Pair(nums[i], i));
        }

        mergeSort(pairs, 0, n - 1, result);
        return Arrays.asList(result);
    }

    private void mergeSort(List<Pair> pairs, int left, int right, Integer[] result) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;
        mergeSort(pairs, left, mid, result);
        mergeSort(pairs, mid + 1, right, result);
        merge(pairs, left, mid, right, result);
    }

    private void merge(List<Pair> pairs, int left, int mid, int right, Integer[] result) {
        List<Pair> temp = new ArrayList<>();
        int i = left, j = mid + 1;
        int rightCount = 0;

        while (i <= mid && j <= right) {
            if (pairs.get(i).value <= pairs.get(j).value) {
                result[pairs.get(i).index] += rightCount;
                temp.add(pairs.get(i++));
            } else {
                rightCount++;
                temp.add(pairs.get(j++));
            }
        }

        while (i <= mid) {
            result[pairs.get(i).index] += rightCount;
            temp.add(pairs.get(i++));
        }

        while (j <= right) {
            temp.add(pairs.get(j++));
        }

        for (int k = left; k <= right; k++) {
            pairs.set(k, temp.get(k - left));
        }
    }

    private static class Pair {
        int value, index;

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
