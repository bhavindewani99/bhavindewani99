class Solution {
    public int numSubseq(int[] nums, int target) {
        long result = 0, mod = (int) 1e9 + 7;
        Arrays.sort(nums);

        for (int left = 0; left < nums.length; left++) {
            if (nums[left] > target - nums[left]) break;
            int newTarget = target - nums[left];
            int rightIndex = binarySearch(nums, newTarget);

            if (rightIndex >= left) {
                result = (result + modPow(2, rightIndex - left, mod)) % mod;
            }
        }
        return (int) result;
    }

    private int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1, index = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= target) {
                index = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return index;
    }

    private long modPow(long base, int exp, long mod) {
        long result = 1;
        //base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }
}
