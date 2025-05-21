class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        // Step 1: Sort envelopes by width ASC and height DESC if widths are same
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1]; // descending height
            } else {
                return a[0] - b[0]; // ascending width
            }
        });

        // Step 2: Extract heights
        int[] heights = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            heights[i] = envelopes[i][1];
        }

        // Step 3: Apply Longest Increasing Subsequence (LIS) on heights
        return lengthOfLIS(heights);
    }

    private int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;

        for (int num : nums) {
            int idx = binarySearch(dp, 0, len, num);
            dp[idx] = num;
            if (idx == len) len++;
        }

        return len;
    }

    private int binarySearch(int[] dp, int left, int right, int target) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (dp[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
