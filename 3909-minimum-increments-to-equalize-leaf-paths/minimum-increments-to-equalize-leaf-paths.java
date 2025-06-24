class Solution {
    int ans = 0;

    public int minIncrease(int n, int[][] edges, int[] cost) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        dfs(0, -1, adj, cost);
        return ans;
    }

    // Returns: max path cost from this node to leaf
    public long dfs(int node, int parent, List<List<Integer>> adj, int[] cost) {
        List<Long> childCosts = new ArrayList<>();

        for (int nei : adj.get(node)) {
            if (nei != parent) {
                childCosts.add(dfs(nei, node, adj, cost));
            }
        }

        if (childCosts.isEmpty()) return cost[node];

        long maxChild = Collections.max(childCosts);

        for (long val : childCosts) {
            if (val < maxChild) ans++;
        }

        return cost[node] + maxChild;
    }
}