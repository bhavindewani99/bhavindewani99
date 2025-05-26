class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {

        // Step 1: Sort all queries by their start time
        Arrays.sort(queries, (a, b) -> a[0] - b[0]);

        // A max-heap to store available query end times (to prioritize longer duration queries)
        PriorityQueue<Integer> availableQueries = new PriorityQueue<>(Collections.reverseOrder());

        // A min-heap to keep track of queries currently in use (based on end time)
        PriorityQueue<Integer> usedQueries = new PriorityQueue<>();

        int queryIndex = 0;                  // Pointer to traverse sorted queries
        int operation = 0;                   // Count of queries that are actually used
        int queryLength = queries.length;    // Total number of queries

        for (int i = 0; i < nums.length; i++) {
            // Add all queries starting at current index 'i' to availableQueries
            while (queryIndex < queryLength && queries[queryIndex][0] == i) {
                availableQueries.offer(queries[queryIndex][1]); // Push only the end time
                queryIndex++;
            }

            // Reduce current nums[i] by the number of already applied queries (currently active)
            nums[i] -= usedQueries.size();

            // If still nums[i] > 0, apply available queries (greedily pick those ending farthest)
            while (nums[i] > 0 && !availableQueries.isEmpty() && availableQueries.peek() >= i) {
                usedQueries.offer(availableQueries.poll()); // Use this query
                operation++;   // Count this query as used
                nums[i]--;     // One operation applied to this index
            }

            // If still nums[i] > 0 after exhausting possible queries, return -1 (not solvable)
            if (nums[i] > 0) return -1;

            // Remove expired queries that end at this index
            while (!usedQueries.isEmpty() && usedQueries.peek() == i) {
                usedQueries.poll(); // This query's range ends at 'i', so it's no longer active
            }
        }

        // Return the number of queries that were not used
        return queryLength - operation;
    }
}
