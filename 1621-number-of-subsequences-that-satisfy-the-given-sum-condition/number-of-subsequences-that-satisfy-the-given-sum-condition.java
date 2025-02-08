import java.util.Arrays;

class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums); // Sort the array
        int mod = (int) (1e9 + 7);
        int res = 0;

        int left = 0, right = nums.length - 1;

        while (left <= right) {
            if (nums[left] + nums[right] > target) {
                right--; // Reduce the sum by moving the right pointer
            } else {
                // Calculate 2^(right - left) % mod
                res += power(2, right - left, mod);
                res %= mod; // Ensure result stays within modulo
                left++; // Increase the sum by moving the left pointer
            }
        }

        return res;
    }

    // Helper function to calculate (base^exp) % mod
    private int power(int base, int exp, int mod) {
        long result = 1;
        long baseMod = base;

        while (exp > 0) {
            if ((exp & 1) == 1) { // If exp is odd
                result = (result * baseMod) % mod;
            }
            baseMod = (baseMod * baseMod) % mod; // Square the base
            exp >>= 1; // Divide exp by 2
        }

        return (int) result;
    }
}
