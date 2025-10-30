class Solution {
    public int minFlips(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        Queue<int[][]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        int[][] dirs = {{0,0},{1,0},{-1,0},{0,1},{0,-1}};
        int flips = 0;

        queue.offer(mat);
        visited.add(getHash(mat));

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int s = 0; s < size; s++) {
                int[][] curr = queue.poll();
                if (getOnes(curr) == 0) return flips;

                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        int[][] next = copyMatrix(curr, m, n);
                        for (int[] d : dirs) {
                            int x = i + d[0], y = j + d[1];
                            if (x >= 0 && y >= 0 && x < m && y < n) {
                                next[x][y] = 1 - curr[x][y];
                            }
                        }

                        String key = getHash(next);
                        if (visited.add(key)) queue.offer(next);
                    }
                }
            }
            flips++;
        }
        return -1;
    }

    private int[][] copyMatrix(int[][] mat, int m, int n) {
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++)
            System.arraycopy(mat[i], 0, res[i], 0, n);
        return res;
    }

    private int getOnes(int[][] mat) {
        int cnt = 0;
        for (int[] row : mat)
            for (int x : row)
                if (x == 1) cnt++;
        return cnt;
    }

    private String getHash(int[][] mat) {
        StringBuilder sb = new StringBuilder();
        for (int[] row : mat)
            for (int x : row)
                sb.append(x);
        return sb.toString();
    }
}
