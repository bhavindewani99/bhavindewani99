class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int remove = 0;
        Union obj1 = new Union(n);
        Union obj2 = new Union(n);

        // Type 3 edges: usable by both
        for (int[] edge : edges) {
            int type = edge[0], u = edge[1] - 1, v = edge[2] - 1;
            if (type == 3) {
                if (obj1.belongs(u, v)) remove++;
                else {
                    obj1.unionBySize(u, v);
                    obj2.unionBySize(u, v);
                }
            }
        }

        // Type 1 and 2 edges
        for (int[] edge : edges) {
            int type = edge[0], u = edge[1] - 1, v = edge[2] - 1;
            if (type == 1) {
                if (obj1.belongs(u, v)) remove++;
                else obj1.unionBySize(u, v);
            } else if (type == 2) {
                if (obj2.belongs(u, v)) remove++;
                else obj2.unionBySize(u, v);
            }
        }

        // Check connectivity
        int root1 = obj1.findParent(0);
        int root2 = obj2.findParent(0);
        for (int i = 0; i < n; i++) {
            if (obj1.findParent(i) != root1 || obj2.findParent(i) != root2)
                return -1;
        }

        return remove;
    }

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

        int findParent(int node) {
            if (parent[node] == node) return node;
            return parent[node] = findParent(parent[node]);
        }

        void unionBySize(int u, int v) {
            int upar = findParent(u);
            int vpar = findParent(v);
            if (upar == vpar) return;
            if (size[upar] >= size[vpar]) {
                parent[vpar] = upar;
                size[upar] += size[vpar];
            } else {
                parent[upar] = vpar;
                size[vpar] += size[upar];
            }
        }

        boolean belongs(int u, int v) {
            return findParent(u) == findParent(v);
        }
    }
}
