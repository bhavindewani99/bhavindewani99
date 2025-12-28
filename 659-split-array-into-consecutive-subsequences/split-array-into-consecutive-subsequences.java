class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> tail = new HashMap<>();

        for (int x : nums) count.put(x, count.getOrDefault(x, 0) + 1);

        for (int x : nums) {
            if (count.get(x) == 0) continue;

            // use x
            count.put(x, count.get(x) - 1);

            // extend a subsequence ending at x-1
            if (tail.getOrDefault(x - 1, 0) > 0) {
                tail.put(x - 1, tail.get(x - 1) - 1);
                tail.put(x, tail.getOrDefault(x, 0) + 1);
            }
            // start new subsequence x, x+1, x+2
            else if (count.getOrDefault(x + 1, 0) > 0 && count.getOrDefault(x + 2, 0) > 0) {
                count.put(x + 1, count.get(x + 1) - 1);
                count.put(x + 2, count.get(x + 2) - 1);
                tail.put(x + 2, tail.getOrDefault(x + 2, 0) + 1);
            } else {
                return false;
            }
        }
        return true;
    }
}
