import java.util.*;

class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[][] sortedTasks = new int[n][3];

        // Add original index to tasks
        for (int i = 0; i < n; i++) {
            sortedTasks[i][0] = tasks[i][0]; // enqueue time
            sortedTasks[i][1] = tasks[i][1]; // processing time
            sortedTasks[i][2] = i;           // original index
        }

        // Sort tasks by enqueue time
        Arrays.sort(sortedTasks, (a, b) -> Integer.compare(a[0], b[0]));

        // Min-heap based on processing time, then index
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) return Integer.compare(a[2], b[2]);
            return Integer.compare(a[1], b[1]);
        });

        int time = 0, index = 0, resultIndex = 0;
        int[] result = new int[n];

        while (index < n || !pq.isEmpty()) {
            // Enqueue tasks that are available at current time
            while (index < n && sortedTasks[index][0] <= time) {
                pq.offer(sortedTasks[index++]);
            }

            if (!pq.isEmpty()) {
                int[] task = pq.poll();
                time += task[1]; // process the task
                result[resultIndex++] = task[2];
            } else {
                // If no tasks are available, jump to the next task's enqueue time
                time = sortedTasks[index][0];
            }
        }

        return result;
    }
}
