class Solution {
    int[] parent;
    int[] size;

    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0]; // Sort by the first element in each sub-array
            }
        });
        parent = new int[n];
        size= new int[n];

        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }

        for(int[] log : logs){
            int u = log[1];
            int v = log[2];
            int parent1 = findParent(u);
            int parent2 = findParent(v);
            if(parent1!=parent2){
                unionBySize(parent1, parent2);
                n--;
                if(n==1) return log[0];
            }
        }
        return -1;



    }

    private int findParent(int node){
        if(parent[node]!=node) 
        parent[node] = findParent(parent[node]);
        return parent[node];
    }

    private void unionBySize(int parent1, int parent2){
        if(size[parent1]>=size[parent2]){
            size[parent1] += size[parent2];
            parent[parent2] = parent1;
        }else{
            size[parent2] += size[parent1];
            parent[parent1] = parent2;
        }
    }
}