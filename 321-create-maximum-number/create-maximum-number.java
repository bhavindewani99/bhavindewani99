import java.util.*;

class Solution {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length, len2 = nums2.length;
        int[] best = new int[k];

        // Try all possible splits between nums1 and nums2
        for (int i = Math.max(0, k - len2); i <= Math.min(k, len1); i++) {
            int[] subseq1 = maxSubsequence(nums1, i);
            int[] subseq2 = maxSubsequence(nums2, k - i);
            int[] merged = merge(subseq1, subseq2);

            if (isGreater(merged, 0, best, 0)) {
                best = merged;
            }
        }

        return best;
    }

    // Builds the largest subsequence of length k from nums
    private int[] maxSubsequence(int[] nums, int k) {
        int[] stack = new int[k];
        int top = -1;
        int remaining = nums.length;

        for (int num : nums) {
            // Remove smaller numbers if we can still fill k-length
            while (top >= 0 && stack[top] < num && remaining > k - top - 1) {
                top--;
            }

            // Add current number if stack not full
            if (top + 1 < k) {
                stack[++top] = num;
            }

            remaining--;
        }

        return stack;
    }

    // Merge two subsequences into the largest possible number
    private int[] merge(int[] nums1, int[] nums2) {
        int i = 0, j = 0, idx = 0;
        int len1 = nums1.length, len2 = nums2.length;
        int[] result = new int[len1 + len2];

        while (i < len1 || j < len2) {
            // Choose the lexicographically greater remaining sequence
            if (isGreater(nums1, i, nums2, j)) {
                result[idx++] = nums1[i++];
            } else {
                result[idx++] = nums2[j++];
            }
        }

        return result;
    }

    // Compare two arrays lexicographically starting at given indices
    private boolean isGreater(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }

        // True if nums1 is longer or lexicographically larger at this point
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }
}
