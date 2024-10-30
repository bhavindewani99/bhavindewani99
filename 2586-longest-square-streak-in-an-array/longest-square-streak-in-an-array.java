class Solution {
    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        Set<Long> set = new HashSet<>();
        Set<Long> used = new HashSet<>();
        int res = -1;

        for (int i : nums) set.add((long) i);

        for (int i : nums) {
            long start = (long) i;
            if (!used.contains(start)) {
                int currLength = 1;
                long x = start*start;

                while (set.contains(x)) {
                    used.add(x);
                    x = x * x;
                    currLength++;
                }
                
                if (currLength >= 2) {
                    res = Math.max(res, currLength);
                }
            }
            
            //used.add(start);
        }

        return res;
    }
}
