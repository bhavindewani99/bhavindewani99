import java.util.HashMap;
import java.util.Map;

class Solution {
    private final int mod = 1000000007;

    public int sumOfGoodSubsequences(int[] nums) {
        Map<Integer, Long> cnt = new HashMap<>();
        Map<Integer, Long> sum = new HashMap<>();

        // Loop through all numbers in the nums array
        for (int num : nums) {
            // Fetch or initialize values
            long cntPrev = cnt.getOrDefault(num - 1, 0L);
            long cntNext = cnt.getOrDefault(num + 1, 0L);
            long currentCnt = cnt.getOrDefault(num, 0L);

            // Update cnt[num] by considering subsequences from num-1, num, and num+1
            long newCnt = (cntPrev + cntNext + 1) % mod;
            cnt.put(num, (currentCnt + newCnt) % mod);

            // Fetch or initialize sums
            long sumPrev = sum.getOrDefault(num - 1, 0L);
            long sumNext = sum.getOrDefault(num + 1, 0L);
            long currentSum = sum.getOrDefault(num, 0L);

            // Update sum[num] by considering subsequences from num-1, num, and num+1
            long newSum = (sumPrev + sumNext) % mod;

            // Add the contribution of the subsequences that end at num
            newSum = (newSum + ((cntPrev + cntNext + 1) % mod) * num % mod) % mod;
            sum.put(num, (currentSum + newSum) % mod);
        }

        // Calculate the final result by summing all the values in sum
        long res = 0;
        for (long value : sum.values()) {
            res = (res + value) % mod;
        }

        return (int) res;
    }
}
