class Solution {
    public int countComponents(int n, int[][] edges) {
        
        Union union = new Union(n);

        for(int[] edge : edges){
            union.unionBySize(edge[0], edge[1]);
        }

        int components = 0;

        for(int i=0;i<n;i++){
            if(union.parent[i]==i) components++;
        }

        return components;
    }

    class Union{
        int n;
        int[] parent, size;
        Union(int n){
            this.n = n;
            this.parent = new int[n];
            this.size = new int[n];

            for(int i=0;i<n;i++){
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int findParent(int node){
            if(parent[node]==node) return node;
            return findParent(parent[node]);
        }

        public void unionBySize(int node1, int node2){
            int parent1 = findParent(node1);
            int parent2 = findParent(node2);
            if(parent1==parent2) return;
            if(size[parent1] >= size[parent2]){
                size[parent1] += size[parent2];
                parent[parent2] = parent1;
            }else{
                size[parent2] += size[parent1];
                parent[parent1] = parent2;
            }
        }
    }
}