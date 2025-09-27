class Solution {
    private static final int MOD = 1_000_000_007;

    public int minAbsoluteSumDiff(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int[] sortedArr1 = arr1.clone();
        Arrays.sort(sortedArr1);

        int totalSum = 0;
        int maxReduction = 0;

        for (int i = 0; i < n; i++) {
            int originalDiff = Math.abs(arr1[i] - arr2[i]);
            totalSum = (totalSum + originalDiff) % MOD;

            int closestIdx = findClosestElement(arr2[i], sortedArr1);
            int bestDiff = Math.abs(sortedArr1[closestIdx] - arr2[i]);

            if (closestIdx + 1 < n) {
                bestDiff = Math.min(bestDiff, Math.abs(sortedArr1[closestIdx + 1] - arr2[i]));
            }

            int reduction = originalDiff - bestDiff;
            if (reduction > maxReduction) {
                maxReduction = reduction;
            }
        }

        return (totalSum - maxReduction + MOD) % MOD;
    }

    private int findClosestElement(int target, int[] sortedArr) {
        int index = 0;
        int low = 0, high = sortedArr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (sortedArr[mid] <= target) {
                index = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return index;
    }
}
