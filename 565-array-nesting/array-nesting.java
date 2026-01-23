class Solution {

    public int arrayNesting(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (result[i] == -1) {
                ans = Math.max(ans, getSize(i, nums, result, new HashSet<>()));
            }
        }
        return ans;
    }

    private int getSize(int index, int[] nums, int[] result, Set<Integer> visiting) {
        // already computed
        if (result[index] != -1) return result[index];

        // cycle detected
        if (visiting.contains(index)) {
            return 0;
        }

        visiting.add(index);

        int size = 1 + getSize(nums[index], nums, result, visiting);

        //visiting.remove(index);
        result[index] = size;
        return size;
    }
}
