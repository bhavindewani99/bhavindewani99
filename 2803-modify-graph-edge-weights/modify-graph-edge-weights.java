class Solution {
    class Edge {
        int to, index;

        Edge(int to, int index) {
            this.to = to;
            this.index = index;
        }
    }

    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        
        List<Edge>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1];
            graph[u].add(new Edge(v, i));
            graph[v].add(new Edge(u, i));
        }

        int[][] dist = new int[n][2];
        for (int i = 0; i < n; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
        dist[source][0] = dist[source][1] = 0;

        dijkstra(graph, edges, dist, source, 0, 0);
        int diff = target - dist[destination][0];
        if (diff < 0) return new int[][]{};
        dijkstra(graph, edges, dist, source, diff, 1);
        if (dist[destination][1] < target) return new int[][]{}; 

        for (int[] edge : edges) if (edge[2] == -1) edge[2] = 1;
        return edges;
    }

    private void dijkstra(List<Edge>[] graph, int[][] edges, int[][] dist, int source, int diff, int pass) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{source, 0});
        dist[source][pass] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0], currDist = curr[1];

            if (currDist > dist[node][pass]) continue;

            for (Edge edge : graph[node]) {
                int neighbor = edge.to, edgeIndex = edge.index;
                int weight = edges[edgeIndex][2] == -1 ? 1 : edges[edgeIndex][2];

                if (pass == 1 && edges[edgeIndex][2] == -1) {
                    weight = diff + dist[neighbor][0] - dist[node][1];
                    edges[edgeIndex][2] = Math.max(weight, 1);
                }

                if (dist[neighbor][pass] > dist[node][pass] + weight) {
                    dist[neighbor][pass] = dist[node][pass] + weight;
                    pq.add(new int[]{neighbor, dist[neighbor][pass]});
                }
            }
        }
    }
}
