class Solution {
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        
        Union union = new Union(n);
        int[] result = new int[query.length];

        // Union all edges and merge weights into component AND
        for(int[] edge : edges){
            int u = edge[0], v = edge[1], w = edge[2];
            union.joinBySize(u, v, w);
        }

        // Answer queries
        for(int i=0; i<query.length; i++){
            int u = query[i][0], v = query[i][1];
            int uPar = union.findParent(u);
            int vPar = union.findParent(v);

            if(uPar != vPar) result[i] = -1;
            else result[i] = union.compAnd[uPar];
        }

        return result;
    }

    class Union{
        int[] parent, size;
        int[] compAnd;

        Union(int n){
            parent = new int[n];
            size = new int[n];
            compAnd = new int[n];

            for(int i=0; i<n; i++){
                parent[i] = i;
                size[i] = 1;          // FIXED: must be 1, not i
                compAnd[i] = -1;      // all bits 1 initially
            }
        }

        public int findParent(int node){
            if(parent[node] == node) return node;
            return parent[node] = findParent(parent[node]);
        }

        public void joinBySize(int u, int v, int w){
            int uPar = findParent(u);
            int vPar = findParent(v);

            if(uPar == vPar){
                // just update AND with the new edge
                compAnd[uPar] &= w;
                return;
            }

            // combine current AND values
            int newAnd = w;
            newAnd &= compAnd[uPar];
            newAnd &= compAnd[vPar];

            if(size[uPar] >= size[vPar]){
                parent[vPar] = uPar;
                size[uPar] += size[vPar];
                compAnd[uPar] = newAnd;
            }else{
                parent[uPar] = vPar;
                size[vPar] += size[uPar];
                compAnd[vPar] = newAnd;
            }
        }
    }
}
