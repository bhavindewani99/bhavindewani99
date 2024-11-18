class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if(n==1){
            res.add(0);
            return res;
        }

        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++) graph.add(new ArrayList<>());

        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int[] indegree = new int[n];
        Queue<Integer> leaves = new LinkedList<>();
        for(int i=0;i<n;i++){
            indegree[i] = graph.get(i).size();
            if(indegree[i]==1){
                leaves.add(i);
            } 
        }

        while(n>2){
            int len = leaves.size();
            n -= len;
            for(int i=0;i<len;i++){
                int leafNode = leaves.poll();;
                for(int adjNode : graph.get(leafNode)){
                    indegree[adjNode]--;
                    if(indegree[adjNode]==1){
                        leaves.add(adjNode);
                    }
                }
            }
        }
        res.addAll(leaves);
        return res;
    }
}