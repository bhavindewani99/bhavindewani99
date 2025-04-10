class Solution {
    public int sumDistance(int[] nums, String s, int d) {
        int n = nums.length;
        long[] pos = new long[n];
        long MOD = 1_000_000_007;
        
        for (int i = 0; i < n; i++) {
            pos[i] = nums[i];
            if (s.charAt(i) == 'R') {
                pos[i] += d;
            } else {
                pos[i] -= d;
            }
        }

        Arrays.sort(pos);

        long prefixSum = 0;
        long result = 0;

        for (int i = 0; i < n; i++) {
            result = (result + i * pos[i] - prefixSum) % MOD;
            prefixSum += pos[i];
        }

        return (int) result;
    }
}
