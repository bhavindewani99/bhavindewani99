class Solution {
    public int arrayNesting(int[] nums) {
        int best = 0;

        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            int cur = i;

            // Walk the chain and mark visited by overwriting with -1
            while (nums[cur] != -1) {
                int next = nums[cur];
                nums[cur] = -1;
                cur = next;
                count++;
            }

            if (count > best) best = count;
        }

        return best;
    }
}
