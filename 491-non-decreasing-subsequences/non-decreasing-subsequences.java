class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), 0, nums);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> curr, int index, int[] nums) {
        // Add to result as soon as we find a valid subsequence
        if (curr.size() >= 2) {
            res.add(new ArrayList<>(curr));
        }

        // Use a set to track numbers used at THIS specific recursion depth
        Set<Integer> used = new HashSet<>();
        
        for (int i = index; i < nums.length; i++) {
            // Check for non-decreasing AND ensure we haven't used this number at this level
            if ((curr.isEmpty() || nums[i] >= curr.get(curr.size() - 1)) && !used.contains(nums[i])) {
                used.add(nums[i]);
                curr.add(nums[i]);
                backtrack(res, curr, i + 1, nums);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
