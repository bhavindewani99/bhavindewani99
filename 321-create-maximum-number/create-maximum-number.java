import java.util.*;

class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        int[] res = new int[k];
        for (int i = Math.max(0, k - n); i <= Math.min(k, m); i++) {
            int[] candidate = merge(maxSubsequence(nums1, i), maxSubsequence(nums2, k - i));
            if (greater(candidate, 0, res, 0)) res = candidate;
        }
        return res;
    }

    private int[] maxSubsequence(int[] nums, int k) {
        int[] stack = new int[k];
        int top = -1, remain = nums.length;
        for (int num : nums) {
            while (top >= 0 && stack[top] < num && remain > k - top - 1) top--;
            if (top + 1 < k) stack[++top] = num;
            remain--;
        }
        return stack;
    }

    private int[] merge(int[] nums1, int[] nums2) {
        int x = nums1.length, y = nums2.length;
        int[] merged = new int[x + y];
        int i = 0, j = 0, idx = 0;
        while (i < x || j < y)
            merged[idx++] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        return merged;
    }

    private boolean greater(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++; j++;
        }
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }
}
