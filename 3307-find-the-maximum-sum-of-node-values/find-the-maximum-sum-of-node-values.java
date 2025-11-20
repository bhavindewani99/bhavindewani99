class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        int n = nums.length;
        long[] delta = new long[n];
        long result = 0;

        for (int i = 0; i < n; i++) {
            delta[i] = (nums[i] ^ k) - nums[i];
            result += nums[i];
        }

        Arrays.sort(delta); 

        for (int i = n - 1; i > 0; i -= 2) {
            long sum = delta[i] + delta[i - 1];
            if (sum > 0) result += sum;
        }

        return result;
    }
}
