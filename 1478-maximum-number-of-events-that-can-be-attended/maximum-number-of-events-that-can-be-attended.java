class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0])); // sort by start day

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // stores end days
        int day = 1, i = 0, n = events.length, attended = 0;

        int lastDay = 0;
        for (int[] e : events) lastDay = Math.max(lastDay, e[1]);

        for (day = 1; day <= lastDay; day++) {
            // Add events starting today
            while (i < n && events[i][0] == day) {
                minHeap.offer(events[i][1]);
                i++;
            }

            // Remove events that already expired
            while (!minHeap.isEmpty() && minHeap.peek() < day) {
                minHeap.poll();
            }

            // Attend one event with earliest end day
            if (!minHeap.isEmpty()) {
                minHeap.poll();
                attended++;
            }
        }

        return attended;
    }
}
