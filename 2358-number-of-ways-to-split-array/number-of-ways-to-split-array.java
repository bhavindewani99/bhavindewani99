class Solution {
    public int waysToSplitArray(int[] nums) {
    int n = nums.length;
    long[] prefix = new long[n];
    prefix[0] = nums[0];
    int result = 0;

    for (int i = 1; i < n; i++) {
        prefix[i] = prefix[i - 1] + nums[i];
    }

    for (int i = 0; i < n - 1; i++) {
        long pre = prefix[i];
        long suff = prefix[n - 1] - pre;
        if (pre >= suff) result++;
    }

    return result;
}

}
