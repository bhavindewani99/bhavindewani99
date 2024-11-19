class Solution {
    private final int mod = 1000000007;

    public int sumOfGoodSubsequences(int[] nums) {
        Map<Integer, Long> cnt = new HashMap<>();
        Map<Integer, Long> sum = new HashMap<>();

        for (int num : nums) {
            long cntPrev = cnt.getOrDefault(num - 1, 0L);
            long cntNext = cnt.getOrDefault(num + 1, 0L);
            long currentCnt = cnt.getOrDefault(num, 0L);

            long newCnt = (cntPrev + cntNext + 1) % mod;
            cnt.put(num, (currentCnt + newCnt) % mod);

            long sumPrev = sum.getOrDefault(num - 1, 0L);
            long sumNext = sum.getOrDefault(num + 1, 0L);
            long currentSum = sum.getOrDefault(num, 0L);

            long newSum = (sumPrev + sumNext) % mod;

            newSum = (newSum + ((newCnt) % mod) * num % mod) % mod;
            sum.put(num, (currentSum + newSum) % mod);
        }

        long res = 0;
        for (long value : sum.values()) {
            res = (res + value) % mod;
        }

        return (int) res;
    }
}
