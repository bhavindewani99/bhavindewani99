class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        // Sort logs by time
        Arrays.sort(logs, Comparator.comparingInt(a -> a[1]));

        // Store original indices of queries
        int q = queries.length;
        int[][] queriesWithIndex = new int[q][2];
        for (int i = 0; i < q; i++) {
            queriesWithIndex[i][0] = queries[i];
            queriesWithIndex[i][1] = i;
        }
        Arrays.sort(queriesWithIndex, Comparator.comparingInt(a -> a[0]));

        int[] result = new int[q];
        Map<Integer, Integer> freq = new HashMap<>();  // serverId → frequency in window
        int left = 0, right = 0;
        int m = logs.length;

        for (int i = 0; i < q; i++) {
            int queryTime = queriesWithIndex[i][0];
            int windowStart = queryTime - x;

            // Expand right pointer: include logs ≤ queryTime
            while (right < m && logs[right][1] <= queryTime) {
                int server = logs[right][0];
                freq.put(server, freq.getOrDefault(server, 0) + 1);
                right++;
            }

            // Shrink left pointer: exclude logs < windowStart
            while (left < m && logs[left][1] < windowStart) {
                int server = logs[left][0];
                freq.put(server, freq.get(server) - 1);
                if (freq.get(server) == 0) {
                    freq.remove(server);
                }
                left++;
            }

            result[queriesWithIndex[i][1]] = n - freq.size();  // total - active
        }

        return result;
    }
}
