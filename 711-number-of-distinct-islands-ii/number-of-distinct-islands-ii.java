class Solution {
    int m, n;
    int[][] grid;
    public int numDistinctIslands2(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid=grid;
        Set<String> seen = new HashSet<>();
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 1){
                    List<int[]> cur = new ArrayList<>();
                    dfs(i, j, cur);
                    seen.add(norm(cur));
                }
            }
        }
        return seen.size();
    }

    private String norm(List<int[]> cur){
        int[][][] all = new int[8][cur.size()][2];
        for (int i = 0; i < cur.size(); i++){
            int x = cur.get(i)[0], y = cur.get(i)[1];
            all[0][i] = new int[]{x, y};
            all[1][i] = new int[]{-x, y};
            all[2][i] = new int[]{x, -y};
            all[3][i] = new int[]{-x, -y};
            all[4][i] = new int[]{y, x};
            all[5][i] = new int[]{-y, x};
            all[6][i] = new int[]{y, -x};
            all[7][i] = new int[]{-y, -x};
        }
        String ans = "";
        for (int[][] a : all){
            Arrays.sort(a, Comparator.<int[]>comparingInt(o -> o[0]).thenComparingInt(o -> o[1]));
            StringBuilder sb = new StringBuilder();
            for (int i = a.length-1; i >= 0; i--){
                sb.append(String.format("(%d %d)", a[i][0]-a[0][0], a[i][1]-a[0][1]));
            }
            if (ans.isEmpty() || ans.compareTo(sb.toString()) > 0){
                ans = sb.toString();
            }
        }
        return ans;
    }

    private void dfs(int i, int j, List<int[]> cur){
        if (i < 0 || j < 0 || i == m || j == n || grid[i][j] == 0){
            return;
        }
        cur.add(new int[]{i, j});
        grid[i][j] = 0;
        dfs(i, j-1, cur);
        dfs(i, j+1, cur);
        dfs(i+1, j, cur);
        dfs(i-1, j, cur);
    }
}