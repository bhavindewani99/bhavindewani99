class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] result = new double[queries.size()];
        Map<String, List<Pair>> graph = new HashMap<>();

        for(int i=0;i<values.length;i++){
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double w = values[i];

            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());

            graph.get(u).add(new Pair(v, w));
            graph.get(v).add(new Pair(u, 1 / w));
        }

        for(int i=0;i<result.length;i++){
            result[i] = bfs(queries.get(i).get(0), queries.get(i).get(1), graph);
        }

        return result;

    }

    private double bfs(String source, String target, Map<String, List<Pair>> graph){

        if (!graph.containsKey(source) || !graph.containsKey(target)) return -1.0;

        if (source.equals(target)) return 1.0;

        Set<String> visited = new HashSet<>();
        Queue<Pair> queue = new LinkedList<>();
        visited.add(source);
        queue.offer(new Pair(source, 1));

        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            String node = pair.node;
            double weight = pair.weight;

            if(node.equals(target)) return weight;

            if(graph.containsKey(node)==false) continue;

            for(Pair adjPair : graph.get(node)){
                String adjNode = adjPair.node;
                double adjWeight = adjPair.weight;
                if(!visited.contains(adjNode)){
                    visited.add(adjNode);
                    queue.offer(new Pair(adjNode, weight*adjWeight));
                }
            }
        }

        return -1.0;
    }

    class Pair{
        String node;
        double weight;
        Pair(String node, double weight){
            this.node = node;
            this.weight = weight;
        }
    }
}