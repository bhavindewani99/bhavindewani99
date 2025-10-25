import java.util.*;

class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] direction = {{0,0}, {0,1}, {0,-1}, {1,0}, {-1,0}}; // 1:right, 2:left, 3:down, 4:up

        int[][] dist = new int[m][n];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[0][0] = 0;

        Deque<int[]> dq = new ArrayDeque<>();
        dq.offerFirst(new int[]{0, 0});

        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();
            int x = cur[0], y = cur[1];

            for (int d = 1; d <= 4; d++) {
                int r = x + direction[d][0];
                int c = y + direction[d][1];

                if (r >= 0 && c >= 0 && r < m && c < n) {
                    int cost = (grid[x][y] == d) ? 0 : 1;
                    if (dist[x][y] + cost < dist[r][c]) {
                        dist[r][c] = dist[x][y] + cost;
                        if (cost == 0) dq.offerFirst(new int[]{r, c});
                        else dq.offerLast(new int[]{r, c});
                    }
                }
            }
        }

        return dist[m - 1][n - 1];
    }
}
