class Solution {
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        
        Union union = new Union(n);
        int[] result = new int[query.length];
        Map<Integer, Integer> map = new HashMap<>();

        for(int[] edge : edges){
            int u = edge[0], v = edge[1], w= edge[2];
            union.joinBySize(u,v, w);
        }

        for(int[] edge : edges){
            int u = edge[0], v = edge[1], w= edge[2];
            int uPar = union.findParent(u);
            if(!map.containsKey(uPar)) map.put(uPar, w);
            else map.put(uPar, (map.get(uPar) & w));
        }

        for(int i=0;i<result.length;i++){
            int u = query[i][0], v = query[i][1];
            int uPar = union.findParent(u), vPar = union.findParent(v);
            if(uPar != vPar) result[i] = -1;
            else result[i] = map.get(uPar);
        }

        return result;
    }


    class Union{
        int n;
        int[] size, parent, minimum;
        Union(int n){
            this.n = n;
            this.parent = new int[n];
            this.size = new int[n];
            this.minimum = new int[n];

            for(int i=0;i<n;i++){
                this.parent[i] = i;
                this.size[i] = i;
                this.minimum[i] = Integer.MAX_VALUE;
            }
        }

        public int findParent(int node){
            if(parent[node] == node) return node;
            return parent[node] = findParent(parent[node]);
        }

        public void joinBySize(int u, int v, int w){
            int uPar = findParent(u), vPar = findParent(v);

            if(size[uPar] >= size[vPar]){
                size[uPar] += size[vPar];
                parent[vPar] = uPar;
            }else{
                size[vPar] += size[uPar];
                parent[uPar] = vPar;
            }
        }
    }
}