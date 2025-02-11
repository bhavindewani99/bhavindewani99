class Solution {
    public int treeDiameter(int[][] edges) {
        
        int n = edges.length + 1;
        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0;i<n;i++) graph.add(new ArrayList<>());

        for(int[] edge : edges){
            int u = edge[0], v =edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        int[] diameter = {0};
        dfs(0, visited, diameter, graph);

        return diameter[0];

    }

    private int dfs(int node, boolean[] visited, int[] diameter, List<List<Integer>> graph){
        int dist1 = 0, dist2 = 0;

        visited[node] = true;
        for(int adjNode : graph.get(node)){
            int distance = 0;
            if(visited[adjNode]==false){
                distance = 1 + dfs(adjNode, visited, diameter, graph);
            }
            if(distance>dist1){
                dist2 = dist1;
                dist1 = distance;
            }else if(distance > dist2){
                dist2 = distance;
            }
        }
        diameter[0] = Math.max(diameter[0], dist1 + dist2);
        return dist1;
    }
}