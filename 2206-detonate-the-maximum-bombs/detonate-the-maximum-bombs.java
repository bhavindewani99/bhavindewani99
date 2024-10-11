class Solution {
    public int maximumDetonation(int[][] bombs) {

        List<List<Integer>> graph = new ArrayList<>();
        int n = bombs.length;
        for(int i=0;i<n;i++) graph.add(new ArrayList<>());
        int res = 1;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int x1 = bombs[i][0], y1 = bombs[i][1], r1 = bombs[i][2];
                int x2 = bombs[j][0], y2 = bombs[j][1], r2 = bombs[j][2];
                double d = Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y2-y1, 2));
                if(d<=r1){
                    graph.get(i).add(j);
                }
                if(d<=r2){
                    graph.get(j).add(i);
                }
            }
        }

        for(int i=0;i<n;i++){
            Set<Integer> set = new HashSet<>();
            dfs(i,set,graph);
            res = Math.max(res, set.size());
        }

        return res;


    }

    private void dfs(int node,Set<Integer> set,List<List<Integer>> graph ){
        set.add(node);
        for(int adjNode : graph.get(node)){
            if(set.contains(adjNode)==false){
                dfs(adjNode, set, graph);
            }
        }
    }
}