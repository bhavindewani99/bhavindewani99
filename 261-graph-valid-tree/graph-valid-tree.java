class Solution {
    public boolean validTree(int n, int[][] edges) {
        
        if (edges.length != n - 1) return false;

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[n];

        if (dfs(0, -1, graph, visited)) return false;

        for (boolean isVisited : visited) {
            if (!isVisited) return false;
        }

        return true;
    }

    private boolean dfs(int node, int parent, List<List<Integer>> graph, boolean[] visited) {
        visited[node] = true;

        for (int adjNode : graph.get(node)) {
            if (!visited[adjNode]) {
                if (dfs(adjNode, node, graph, visited)) return true;
            } else if (adjNode != parent) {
                return true;
            }
        }

        return false;
    }
}
