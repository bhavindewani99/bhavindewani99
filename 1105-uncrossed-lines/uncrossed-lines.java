class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        Integer[][] memo = new Integer[m][n];
        return dfs(0, 0, nums1, nums2, memo);
    }

    private int dfs(int i, int j, int[] nums1, int[] nums2, Integer[][] memo) {
        if (i >= nums1.length || j >= nums2.length) {
            return 0;
        }

        if (memo[i][j] != null) {
            return memo[i][j];
        }

        int result;
        if (nums1[i] == nums2[j]) {
            // Can draw a line, so move both
            result = 1 + dfs(i + 1, j + 1, nums1, nums2, memo);
        } else {
            // Try skipping one from either nums1 or nums2
            int skipNums1 = dfs(i + 1, j, nums1, nums2, memo);
            int skipNums2 = dfs(i, j + 1, nums1, nums2, memo);
            result = Math.max(skipNums1, skipNums2);
        }

        memo[i][j] = result;
        return result;
    }
}
