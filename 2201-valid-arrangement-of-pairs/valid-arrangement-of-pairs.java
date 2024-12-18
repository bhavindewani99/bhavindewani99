class Solution {
    public int[][] validArrangement(int[][] pairs) {
        Map<Integer, LinkedList<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();
        Map<Integer, Integer> outdegree = new HashMap<>();

        // Building graph
        for(int i=0;i<pairs.length;i++){
            int u = pairs[i][0];
            int v = pairs[i][1];
            graph.putIfAbsent(u, new LinkedList<>());
            graph.get(u).add(v);
            indegree.put(v, indegree.getOrDefault(v, 0) + 1);
            outdegree.put(u, outdegree.getOrDefault(u, 0) + 1);
        }

        int startNode = pairs[0][0];
        for(int node : graph.keySet()){
            if(outdegree.get(node) - indegree.getOrDefault(node, 0) == 1){
                startNode = node;
                break;
            }
        }

        Stack<Integer> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        stack.push(startNode);

        //DFS travesal
        while(!stack.isEmpty()){
            int node = stack.peek();
            if(graph.getOrDefault(node, new LinkedList<>()).size()>0){
                stack.push(graph.get(node).removeFirst());
            }else{
                result.add(stack.pop());
            }
        }

        Collections.reverse(result);
        int[][] resultPairs = new int[pairs.length][2];
        for(int i=1;i<result.size();i++){
            resultPairs[i-1][0] = result.get(i-1);
            resultPairs[i-1][1] = result.get(i);
        }

        return resultPairs;
    }
}