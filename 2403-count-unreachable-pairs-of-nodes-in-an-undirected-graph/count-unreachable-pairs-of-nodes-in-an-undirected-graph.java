class Solution {
    public long countPairs(int n, int[][] edges) {
        
        Disjoint disjoint = new Disjoint(n);

        for(int[] edge : edges){
            disjoint.joinBySize(edge[0], edge[1]);
        }

        Map<Integer, List<Integer>> uniqueParents = new HashMap<>();

        for(int i=0;i<n;i++){
            int parent = disjoint.findParent(i);
            uniqueParents.putIfAbsent(parent, new ArrayList<>());
            uniqueParents.get(parent).add(i);
        }

        int totalNodes = n;
        long result = 0;

        for(int parentKey : uniqueParents.keySet()){
            long currNodes = uniqueParents.get(parentKey).size();
            long x = totalNodes - currNodes;
            result += (currNodes * x);
            totalNodes -= currNodes; 
        }

        return result;

    }

    class Disjoint{
        int nodes;
        int[] parent, size;
        Disjoint(int n){
            this.nodes=n;
            this.parent = new int[n];
            this.size = new int[n];

            for(int i=0;i<n;i++){
                this.parent[i]=i;
                this.size[i]=1;
            }
        }

        public int findParent(int node){
            if(parent[node] == node) return node;
            return parent[node] = findParent(parent[node]);
        }

        public void joinBySize(int u, int v){
            int uParent = findParent(u);
            int vParent = findParent(v);
            if(uParent == vParent) return;
            if(size[uParent] >= size[vParent]){
                size[uParent] += size[vParent];
                parent[vParent] = uParent;
            }else{
                size[vParent] += size[uParent];
                parent[uParent] = vParent;
            }
        }
    }
}