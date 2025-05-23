/*
Intuition:
We want the path from top-left to bottom-right where the **minimum value along the path is as large as possible**.
We can use binary search on the minimum value and for each guess, use BFS to check if such a path exists.
*/

import java.util.*;

class Solution {
    public int maximumMinimumPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Set the search range for the minimum path value
        int low = 0;
        int high = Math.min(grid[0][0], grid[m - 1][n - 1]);
        int answer = 0;

        // Binary search to find the maximum minimum value path
        while (low <= high) {
            int mid = (low + high) / 2;

            // Check if it's possible to reach (m-1, n-1) with all values >= mid
            if (canReachEnd(grid, mid)) {
                answer = mid;      // This is a valid candidate
                low = mid + 1;     // Try to find a larger minimum value
            } else {
                high = mid - 1;    // Try a smaller value
            }
        }

        return answer;
    }

    // Helper method to check if a valid path exists using BFS
    private boolean canReachEnd(int[][] grid, int threshold) {
        int m = grid.length;
        int n = grid[0].length;

        // If the starting point doesn't meet the threshold, return false early
        if (grid[0][0] < threshold) return false;

        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        // Directions for movement: up, down, left, right
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        // BFS to explore all valid paths
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0], y = curr[1];

            // If we've reached the destination, the path is valid
            if (x == m - 1 && y == n - 1) return true;

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                // Check boundaries, visited status, and threshold condition
                if (nx >= 0 && ny >= 0 && nx < m && ny < n &&
                    !visited[nx][ny] && grid[nx][ny] >= threshold) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        return false;  // No valid path found for this threshold
    }
}
