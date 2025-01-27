class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        
        List<List<Integer>> graph = new ArrayList<>();
        List<Boolean> result = new ArrayList<>();
        HashMap<Integer, Set<Integer>> map = new HashMap<>();

        for(int i=0;i<numCourses;i++) graph.add(new ArrayList<>());

        for(int i=0;i<prerequisites.length;i++){
            int v = prerequisites[i][0];
            int u = prerequisites[i][1];
            graph.get(u).add(v);
        }

        for(int i=0;i<numCourses;i++) dfs(i, map, graph);

        for(int i=0;i<queries.length;i++){
            int u = queries[i][0];
            int v = queries[i][1];
            if(map.get(v).contains(u)) result.add(true);
            else result.add(false);
        }

        return result;
        
    }

    private void dfs(int node, HashMap<Integer, Set<Integer>> map, List<List<Integer>> graph){
        if(map.containsKey(node)==false){
            map.put(node, new HashSet<>());
            for(int adjNode : graph.get(node)){
                map.get(node).add(adjNode);
                dfs(adjNode, map, graph);
                map.get(node).addAll(map.get(adjNode));
            }
        }
    }
}