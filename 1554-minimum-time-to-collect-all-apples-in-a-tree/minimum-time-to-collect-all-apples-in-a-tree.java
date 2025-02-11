class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> graph = new ArrayList<>();

        // Create the graph representation
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        // Fill the graph with edges
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // Initialize visited array
        boolean[] visited = new boolean[n];
        return dfs(0, visited, graph, hasApple);
    }

    private int dfs(int node, boolean[] visited, List<List<Integer>> graph, List<Boolean> hasApple) {
        visited[node] = true;
        int totalTime = 0;

        // Traverse all neighbors of the current node
        for (int adjNode : graph.get(node)) {
            if (!visited[adjNode]) {
                int subtreeTime = dfs(adjNode, visited, graph, hasApple);

                // Only add time (2) if the subtree has apples or the current node has apples
                if (subtreeTime > 0 || hasApple.get(adjNode)) {
                    totalTime += subtreeTime + 2;  // Add time for this edge (both directions)
                }
            }
        }
        return totalTime;
    }
}
