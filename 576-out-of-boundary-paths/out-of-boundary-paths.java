import java.util.*;

class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        final int MOD = 1_000_000_007;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};

        // "BFS by layers", but we must carry multiplicity (how many ways reach each cell)
        long[][] currWays = new long[m][n];
        currWays[startRow][startColumn] = 1;

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{startRow, startColumn});

        long answer = 0;

        for (int move = 1; move <= maxMove; move++) {
            long[][] nextWays = new long[m][n];
            Queue<int[]> nextQ = new ArrayDeque<>();
            boolean[][] inNextQ = new boolean[m][n]; // only to avoid duplicate positions in queue, not to avoid counting

            while (!q.isEmpty()) {
                int[] cell = q.poll();
                int r = cell[0], c = cell[1];

                long waysHere = currWays[r][c];
                if (waysHere == 0) continue;

                for (int[] d : dirs) {
                    int nr = r + d[0];
                    int nc = c + d[1];

                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                        answer = (answer + waysHere) % MOD;
                    } else {
                        nextWays[nr][nc] = (nextWays[nr][nc] + waysHere) % MOD;
                        if (!inNextQ[nr][nc]) {
                            inNextQ[nr][nc] = true;
                            nextQ.offer(new int[]{nr, nc});
                        }
                    }
                }

                currWays[r][c] = 0; // clear for safety since we are done with this layer
            }

            currWays = nextWays;
            q = nextQ;
        }

        return (int) answer;
    }
}
