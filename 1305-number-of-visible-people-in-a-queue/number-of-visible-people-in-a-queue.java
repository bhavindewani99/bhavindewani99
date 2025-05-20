class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Iterate from right to left: simulate looking to the right of each person
        for (int i = n - 1; i >= 0; i--) {
            int visibleCount = 0;

            // Pop and count all shorter persons (they are fully visible),
            // stop at the first taller or equal person (also visible but blocks further view)
            while (!stack.isEmpty() && heights[i] > stack.peek()) {
                stack.pop();
                visibleCount++;
            }

            if (!stack.isEmpty()) {
                visibleCount++; // Taller or equal person also visible
            }

            result[i] = visibleCount;
            stack.push(heights[i]);
        }

        return result;
    }
}
