class Solution {
    int operation = 0;
    public int minReorder(int n, int[][] connections) {
        
        Set<String> edges = new HashSet<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        for(int[] connection : connections){
            int a = connection[0], b = connection[1];
            edges.add(a+"*"+b);
            graph.putIfAbsent(a, new ArrayList<>());
            graph.putIfAbsent(b, new ArrayList<>());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        visited.add(0);
        dfs(edges, graph, visited, 0);

        return operation;

    }

    private void dfs(Set<String> edges, Map<Integer, List<Integer>> graph, Set<Integer> visited, int currNode){

        for(int neighbor : graph.get(currNode)){
            if(visited.add(neighbor) == true){
                String currEdge = currNode + "*" + neighbor;
                if(edges.contains(currEdge) == true) operation++;
                dfs(edges, graph, visited, neighbor);
            }
        }
    }
}