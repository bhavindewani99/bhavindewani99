class Solution {

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {

        // Step 1: Extend edges with their original index
        int m = edges.length;
        int[][] e = new int[m][4]; // u, v, w, id
        for (int i = 0; i < m; i++) {
            e[i][0] = edges[i][0];
            e[i][1] = edges[i][1];
            e[i][2] = edges[i][2];
            e[i][3] = i;
        }

        // Step 2: Sort edges by weight
        Arrays.sort(e, (a, b) -> a[2] - b[2]);

        // Step 3: Compute base MST weight
        int baseMST = getMST(n, e, -1, -1);

        List<Integer> critical = new ArrayList<>();
        List<Integer> pseudo = new ArrayList<>();

        // Step 4: Check each edge by removing or forcing it
        for (int i = 0; i < m; i++) {

            int excluded = getMST(n, e, i, -1);
            if (excluded == -1 || excluded > baseMST) {
                critical.add(e[i][3]);
                continue; // no need to test pseudo for critical edges
            }

            int forced = getMST(n, e, -1, i);
            if (forced == baseMST) {
                pseudo.add(e[i][3]);
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        result.add(critical);
        result.add(pseudo);
        return result;
    }

    // Kruskal with optional skip/force
    private int getMST(int n, int[][] edges, int skip, int force) {
        Union uf = new Union(n);
        int weight = 0;
        int used = 0;

        // If forcing an edge
        if (force != -1) {
            int[] f = edges[force];
            if (uf.union(f[0], f[1])) {
                weight += f[2];
                used++;
            }
        }

        // Build MST by Kruskal
        for (int i = 0; i < edges.length; i++) {

            if (i == skip) continue;
            if (i == force) continue;

            int[] ed = edges[i];
            if (uf.union(ed[0], ed[1])) {
                weight += ed[2];
                used++;
            }
        }

        // Check if MST is complete
        return used == n - 1 ? weight : -1;
    }

    // Optimized DSU
    class Union {
        int[] parent, size;

        Union(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int x) {
            return parent[x] == x ? x : (parent[x] = find(parent[x]));
        }

        boolean union(int a, int b) {
            int pa = find(a), pb = find(b);
            if (pa == pb) return false;

            if (size[pa] < size[pb]) {
                parent[pa] = pb;
                size[pb] += size[pa];
            } else {
                parent[pb] = pa;
                size[pa] += size[pb];
            }
            return true;
        }
    }
}
