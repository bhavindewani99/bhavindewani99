class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        List<Deque<Integer>> groups = new ArrayList<>(); 
        Map<Integer, Integer> numToGroup = new HashMap<>();

        
        int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums);

        for (int n : sortedNums) {
            if (groups.isEmpty() || Math.abs(n - groups.get(groups.size() - 1).peekLast()) > limit) {
                groups.add(new ArrayDeque<>());
            }
            groups.get(groups.size() - 1).add(n);
            numToGroup.put(n, groups.size() - 1);
        }

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            int groupIndex = numToGroup.get(n);
            res[i] = groups.get(groupIndex).pollFirst(); 
        }

        return res;
    }
}
