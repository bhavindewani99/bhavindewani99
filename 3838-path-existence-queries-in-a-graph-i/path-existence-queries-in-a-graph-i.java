class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        
        boolean[] result = new boolean[queries.length];
        
        UnionSet unionSet = new UnionSet(n);

        for(int i=0;i<n-1;i++){
            if(nums[i+1] - nums[i] <= maxDiff){
                unionSet.uniounBySize(i, i+1);
            }
        }

        int index = 0;
        for(int[] querie : queries){
            int u = querie[0], v = querie[1];
            if(unionSet.findParent(u) == unionSet.findParent(v)){
                result[index] = true;
            }
            index++;
        }

        return result;
    }

}


class UnionSet{
    int n;
    int[] parent;
    int[] size;

    UnionSet(int n){
        this.n = n;
        parent = new int[n];
        size = new int[n];

        for(int i=0;i<n;i++){
            size[i] = 1;
            parent[i] = i;
        }
    }

    public int findParent(int node){
        if(parent[node] == node) return node;
        return parent[node] = findParent(parent[node]);
    }

    public void uniounBySize(int u, int v){
        int uParent = findParent(u), vParent = findParent(v);
        if(uParent==vParent) return;
        else if(size[uParent] > size[vParent]){
            size[uParent] += size[vParent];
            parent[vParent] = uParent;
        }else{
            size[vParent] += size[uParent];
            parent[uParent] = vParent;
        }
    }
}