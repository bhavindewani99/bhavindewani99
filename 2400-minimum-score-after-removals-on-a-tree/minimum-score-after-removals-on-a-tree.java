import java.util.*;

class Solution {
    int timer = 0;

    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;
        int[] tin = new int[n];
        int[] tout = new int[n];
        int[] xor = new int[n];
        int totalXor = 0;

        // compute total xor
        for (int num : nums) totalXor ^= num;

        // build adjacency list
        List<List<Integer>> tree = buildTree(edges, n);

        // precompute xor, tin, tout using DFS
        dfs(0, -1, nums, tree, xor, tin, tout);

        int ans = Integer.MAX_VALUE;

        // iterate over all pairs of edges (remove any 2 edges)
        for (int i = 0; i < n - 1; i++) {
            int a = edges[i][0], b = edges[i][1];
            if (isAncestor(a, b, tin, tout)) {
                int temp = a; a = b; b = temp;
            }

            for (int j = i + 1; j < n - 1; j++) {
                int c = edges[j][0], d = edges[j][1];
                if (isAncestor(c, d, tin, tout)) {
                    int temp = c; c = d; d = temp;
                }

                int x1, x2, x3;

                if (isAncestor(a, c, tin, tout)) {
                    x3 = xor[c];
                    x2 = xor[a] ^ xor[c];
                    x1 = totalXor ^ xor[a];
                } else if (isAncestor(c, a, tin, tout)) {
                    x3 = xor[a];
                    x2 = xor[c] ^ xor[a];
                    x1 = totalXor ^ xor[c];
                } else {
                    x3 = xor[a];
                    x2 = xor[c];
                    x1 = totalXor ^ xor[a] ^ xor[c];
                }

                int maxi = Math.max(x1, Math.max(x2, x3));
                int mini = Math.min(x1, Math.min(x2, x3));
                ans = Math.min(ans, maxi - mini);
            }
        }

        return ans;
    }

    // --- DFS to compute xor, tin, tout ---
    private void dfs(int node, int parent, int[] nums, List<List<Integer>> tree,
                     int[] xor, int[] tin, int[] tout) {
        tin[node] = timer++;
        xor[node] = nums[node];
        for (int nei : tree.get(node)) {
            if (nei != parent) {
                dfs(nei, node, nums, tree, xor, tin, tout);
                xor[node] ^= xor[nei];
            }
        }
        tout[node] = timer++;
    }

    // --- Check if 'a' is ancestor of 'b' ---
    private boolean isAncestor(int a, int b, int[] tin, int[] tout) {
        return tin[a] <= tin[b] && tout[b] <= tout[a];
    }

    // --- Build adjacency list ---
    private List<List<Integer>> buildTree(int[][] edges, int n) {
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++) tree.add(new ArrayList<>());
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            tree.get(u).add(v);
            tree.get(v).add(u);
        }
        return tree;
    }
}
