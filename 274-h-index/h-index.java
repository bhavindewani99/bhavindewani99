public class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] papers = new int[n + 1];

        // Step 1: Count how many papers have 0, 1, ..., n or more citations
        for (int c : citations) {
            // Any citation count greater than n is considered as n
            if (c >= n) {
                papers[n]++;
            } else {
                papers[c]++;
            }
        }

        // Step 2: Start from the highest possible h-index (n) and go down
        int totalPapers = 0; // total number of papers with at least 'i' citations
        for (int i = n; i >= 0; i--) {
            totalPapers += papers[i];
            if (totalPapers >= i) {
                // Found the highest i such that there are at least i papers with i or more citations
                return i;
            }
        }

        // Should never reach here
        return 0;
    }
}
