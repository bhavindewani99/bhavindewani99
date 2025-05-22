class Solution {
// There can be multiple graphs but its sure that 1 and N will be present in the same graph 
// So run the dfs from 1 and it will reach to N for sure
// And just track the minimum among the path as we can revisit the same node we will be able to achieve that minimum value
    int result = Integer.MAX_VALUE;
    public int minScore(int n, int[][] roads) {
        
        Map<Integer, List<Pair>> graph = new HashMap<>();
        Set<Integer> seen = new HashSet();

        for(int road[] : roads){
            int u = road[0], v = road[1], dist = road[2];
            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());
            graph.get(u).add(new Pair(v, dist));
            graph.get(v).add(new Pair(u, dist));
        }

        dfs(1, graph,seen);
        return result;
    }

    private void dfs(int node,Map<Integer, List<Pair>> graph, Set<Integer> seen){
        seen.add(node);

        for(Pair adjPair : graph.get(node)){
            result = Math.min(result, adjPair.distance);
            if(seen.contains(adjPair.node)==false){
                dfs(adjPair.node, graph, seen);
            }
        }
    }

    class Pair{
        int node, distance;
        Pair(int node, int distance){
            this.node = node;
            this.distance = distance;
        }
    }
}