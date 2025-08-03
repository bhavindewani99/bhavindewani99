class Solution {
    public int maximumBeauty(int[] nums, int k) {
        int maxValue = 0;
        for (int i : nums) {
            maxValue = Math.max(maxValue, i + k); // Important: include +k in range
        }

        int[] count = new int[maxValue + 2]; // +2 to handle overflow
        for (int num : nums) {
            int left = Math.max(0, num - k);
            int right = num + k + 1;
            count[left]++;
            if (right < count.length) {
                count[right]--;
            }
        }

        int result = 0;
        int currentSum = 0;
        for (int i = 0; i < count.length; i++) {
            currentSum += count[i];
            result = Math.max(result, currentSum);
        }

        return result;
    }
}
