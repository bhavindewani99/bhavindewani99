import java.util.Arrays;

class Solution {
    int res;

    public int minSessions(int[] tasks, int sessionTime) {
        // 1. Sort the tasks in ascending order
        //Arrays.sort(tasks);
        
        // 2. Reverse the array to make it descending (largest tasks first)
        int n = tasks.length;
        // for (int i = 0; i < n / 2; i++) {
        //     int temp = tasks[i];
        //     tasks[i] = tasks[n - 1 - i];
        //     tasks[n - 1 - i] = temp;
        // }

        // Upper bound: worst case is 1 session per task
        res = n; 
        
        // sessions[i] tracks the time used in the i-th session bucket
        int[] sessions = new int[n];
        
        dfs(0, 0, tasks, sessionTime, sessions);
        return res;
    }

    private void dfs(int taskIndex, int sessionCount, int[] tasks, int sessionTime, int[] sessions) {
        // Pruning 1: If our current session count matches or exceeds our best result, stop.
        if (sessionCount >= res) {
            return;
        }
        
        // Base Case: All tasks are successfully placed into sessions
        if (taskIndex == tasks.length) {
            res = Math.min(res, sessionCount);
            return;
        }

        // Try placing the current task into an existing session bucket
        for (int i = 0; i < sessionCount; i++) {
            if (sessions[i] + tasks[taskIndex] <= sessionTime) {
                sessions[i] += tasks[taskIndex];
                dfs(taskIndex + 1, sessionCount, tasks, sessionTime, sessions);
                sessions[i] -= tasks[taskIndex]; // Backtrack
            }
        }

        // Pruning 2: Try opening a BRAND NEW session bucket for this task
        // We only do this if it won't exceed our current global minimum 'res'
        if (sessionCount + 1 < res) {
            sessions[sessionCount] += tasks[taskIndex];
            dfs(taskIndex + 1, sessionCount + 1, tasks, sessionTime, sessions);
            sessions[sessionCount] -= tasks[taskIndex]; // Backtrack
        }
    }
}
