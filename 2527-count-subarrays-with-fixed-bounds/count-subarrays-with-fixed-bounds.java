class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long result = 0;
        int lastMin = -1;
        int lastMax = -1;
        int lastBad = -1;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (num < minK || num > maxK) {
                lastBad = i;
            }

            if (num == minK) {
                lastMin = i;
            }

            if (num == maxK) {
                lastMax = i;
            }

            int validStart = Math.min(lastMin, lastMax);

            if (validStart > lastBad) {
                result += validStart - lastBad;
            }
        }

        return result;
    }
}
