class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] direction = {{0,0}, {0,1}, {0,-1}, {1,0}, {-1,0}}; // 1: right, 2: left, 3: down, 4: up

        // Distance matrix
        int[][] dist = new int[m][n];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[0][0] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.moves - b.moves);
        pq.offer(new Pair(0, 0, 0));

        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int x = pair.x, y = pair.y, moves = pair.moves;

            // If we reached destination
            if (x == m - 1 && y == n - 1) return moves;

            // Skip if we already found a cheaper path
            if (moves > dist[x][y]) continue;

            // Explore all 4 directions
            for (int d = 1; d <= 4; d++) {
                int r = x + direction[d][0];
                int c = y + direction[d][1];
                if (r >= 0 && c >= 0 && r < m && c < n) {
                    // Use current cell's direction for cost check
                    int cost = (grid[x][y] == d) ? 0 : 1;
                    if (moves + cost < dist[r][c]) {
                        dist[r][c] = moves + cost;
                        pq.offer(new Pair(r, c, dist[r][c]));
                    }
                }
            }
        }
        return -1; // Should never happen for valid grids
    }

    class Pair {
        int x, y, moves;
        Pair(int x, int y, int moves) {
            this.x = x;
            this.y = y;
            this.moves = moves;
        }
    }
}
