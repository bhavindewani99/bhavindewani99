class Solution {
    int result = 0;

    public int numSquarefulPerms(int[] nums) {
        int n = nums.length;
        boolean[] used = new boolean[n];
        // 1. Sort to handle duplicates easily
        Arrays.sort(nums); 
        recursion(nums, used, n, 0, -1);
        return result;
    }

    private void recursion(int[] nums, boolean[] used, int n, int taken, int last) {
        // 2. Base case: Check if all elements are placed
        if (taken == n) { 
            result++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (used[i]) continue;
            
            // 3. Skip duplicate elements to avoid counting identical permutations
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            if (taken == 0 || isValid((long) nums[i] + last)) {
                used[i] = true;
                recursion(nums, used, n, taken + 1, nums[i]);
                used[i] = false;
            }
        }
    }

    private boolean isValid(long x) {
        if (x < 0) return false;
        long sqrt = (long) Math.sqrt(x);
        return (sqrt * sqrt == x);
    }
}
