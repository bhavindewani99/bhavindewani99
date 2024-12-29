class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        int n = nums.length;
        int[] nonIncreasing = new int[n];
        int[] nonDecreasing = new int[n];
        List<Integer> result = new ArrayList<>();

        
        nonIncreasing[0] = 1; 
        for (int i = 1; i < n; i++) {
            if (nums[i] <= nums[i - 1]) {
                nonIncreasing[i] = nonIncreasing[i - 1] + 1;
            } else {
                nonIncreasing[i] = 1;
            }
        }

        nonDecreasing[n - 1] = 1; 
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] <= nums[i + 1]) {
                nonDecreasing[i] = nonDecreasing[i + 1] + 1;
            } else {
                nonDecreasing[i] = 1;
            }
        }

        for (int i = k; i < n - k; i++) {
            if (nonIncreasing[i - 1] >= k && nonDecreasing[i + 1] >= k) {
                result.add(i);
            }
        }

        return result;
    }
}
