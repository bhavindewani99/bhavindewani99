import java.util.*;

class Solution {
    private int[] a, b;
    private int[][] memo;   // -1 means not computed
    private int best;

    public int findLength(int[] nums1, int[] nums2) {
        this.a = nums1;
        this.b = nums2;
        int m = a.length, n = b.length;

        memo = new int[m][n];
        for (int i = 0; i < m; i++) Arrays.fill(memo[i], -1);

        best = 0;

        // We must consider every pair (i, j) as a potential start
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                best = Math.max(best, dfs(i, j));
            }
        }

        return best;
    }

    private int dfs(int i, int j) {
        if (i >= a.length || j >= b.length) return 0;
        if (memo[i][j] != -1) return memo[i][j];

        int ans;
        if (a[i] == b[j]) {
            ans = 1 + dfs(i + 1, j + 1);
        } else {
            ans = 0;
        }

        memo[i][j] = ans;
        return ans;
    }
}
