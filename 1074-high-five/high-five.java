class Solution {
    public int[][] highFive(int[][] items) {
        // Sort by ID first, and then by scores in descending order
        Arrays.sort(items, (a, b) -> (a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]));
        
        List<int[]> result = new ArrayList<>();
        int id = items[0][0];
        int sum = 0;
        int count = 0;

        for (int[] item : items) {
            if (item[0] != id) {
                // Add the result for the previous ID
                result.add(new int[] {id, sum / count});
                // Reset for the new ID
                id = item[0];
                sum = 0;
                count = 0;
            }
            // Sum the top 5 scores for the current ID
            if (count < 5) {
                sum += item[1];
                count++;
            }
        }

        // Add the last ID's result
        result.add(new int[] {id, sum / count});
        
        // Convert the result to a 2D array
        return result.toArray(new int[result.size()][]);
    }
}
