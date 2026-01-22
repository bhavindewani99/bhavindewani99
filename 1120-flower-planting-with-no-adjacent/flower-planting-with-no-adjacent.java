class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        int[] color = new int[n];

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int[] path : paths) {
            int u = path[0] - 1; // convert to 0-based
            int v = path[1] - 1;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (int i = 0; i < n; i++) {
            boolean[] used = new boolean[5]; // 1..4
            for (int nei : graph.get(i)) {
                int c = color[nei];
                if (c != 0) used[c] = true;
            }
            for (int c = 1; c <= 4; c++) {
                if (!used[c]) { color[i] = c; break; }
            }
        }

        return color;
    }
}
