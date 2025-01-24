class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        int n = graph.length;
        boolean[] visited = new boolean[n];
        boolean[] samePath = new boolean[n];
        boolean[] check = new boolean[n];
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, graph, visited, samePath, check);
            }
        }

        for (int i = 0; i < n; i++) {
            if (check[i]) {
                res.add(i);
            }
        }

        return res;
    }

    private boolean dfs(int node, int[][] graph, boolean[] visited, boolean[] samePath, boolean[] check) {
        visited[node] = true;
        samePath[node] = true;
        //check[node]=false;

        // Traverse all neighbors of the node
        for (int i = 0; i < graph[node].length; i++) {
            int adjNode = graph[node][i];

            if (!visited[adjNode]) {
                if (dfs(adjNode, graph, visited, samePath, check)) {
                    return true; // A cycle is found
                }
            } else if (samePath[adjNode]) { // If adjacent node is on the same path, there's a cycle
                return true;
            }
        }

        // If no cycle is found, mark the node as safe
        check[node] = true;
        samePath[node] = false; // Backtrack
        return false; // No cycle detected from this node
    }
}
