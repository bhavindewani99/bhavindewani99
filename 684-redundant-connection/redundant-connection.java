class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] result ={0,0};
        Node node = new Node(edges.length);

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int uparent = node.findParent(u);
            int vparent = node.findParent(v);
            if(uparent==vparent) {
                result = edge;
                continue;
            }
            node.unionBySize(u, v);
        }
        return result;
    }

    class Node{
        int[] parent;
        int[] size;
        Node(int n){
            parent = new int[n+1];
            size = new int[n+1];

            for(int i=0;i<=n;i++){
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int findParent(int node){
            if(parent[node]==node) return node;
            return findParent(parent[node]);
        }

        public void unionBySize(int u, int v){
            int uparent = findParent(u);
            int vparent = findParent(v);
            if(uparent==vparent) return;
            if(size[uparent]>=size[vparent]){
                parent[vparent] = uparent;
                size[uparent] += size[vparent];
            }else{
                parent[uparent] = vparent;
                size[vparent] += size[uparent];
            }
        }
    }
}