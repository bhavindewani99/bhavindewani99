class Solution {
    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        Set<Long> set = new HashSet<>();
        Set<Long> used = new HashSet<>();
        int res = -1;

        // Populate the set with all unique elements from nums
        for (int i : nums) set.add((long) i);

        // Check each number as a potential start of a square sequence
        for (int i : nums) {
            long start = (long) i;
            if (!used.contains(start)) {
                int currLength = 1;
                long x = start*start;

                // Try to find the next square in sequence
                while (set.contains(x)) {
                    used.add(x);
                    x = x * x; // Move to the next square
                    currLength++;
                     // Mark this number as used
                }
                
                // Update max streak if current streak is longer
                if (currLength >= 2) {
                    res = Math.max(res, currLength);
                }
            }
            // Mark the starting number as used
            used.add(start);
        }

        return res;
    }
}
