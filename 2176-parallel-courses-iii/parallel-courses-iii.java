class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        int[] indegree = new int[n + 1];
        for (int[] r : relations) {
            graph.get(r[0]).add(r[1]);
            indegree[r[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        int[] finish = new int[n + 1];

        // start with courses having no prerequisites
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
                finish[i] = time[i - 1];
            }
        }

        int res = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : graph.get(u)) {
                finish[v] = Math.max(finish[v], finish[u] + time[v - 1]);
                if (--indegree[v] == 0) q.offer(v);
            }
            res = Math.max(res, finish[u]);
        }
        return res;
    }
}
