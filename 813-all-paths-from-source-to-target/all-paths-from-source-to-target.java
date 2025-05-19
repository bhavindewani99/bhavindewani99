class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        int totalNodes = graph.length;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currPath = new ArrayList<>();

        dfs(0, graph, result, currPath, totalNodes);

        return result;
    }

    private void dfs(int currNode, int[][] graph, List<List<Integer>> result, List<Integer> currPath, int totalNodes){

        currPath.add(currNode);
        if(currNode == totalNodes - 1){
            result.add(new ArrayList<>(currPath));
            currPath.remove(currPath.size()-1);
            return;
        }

        for(int adjNode : graph[currNode]){
            dfs(adjNode, graph, result, currPath, totalNodes);
        }

        currPath.remove(currPath.size()-1);
    }
}