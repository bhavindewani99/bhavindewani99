class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        
        int n1 = edges1.length + 1; // total nodes in tree 1
        int n2 = edges2.length + 1; // total nodes in tree 2

        List<List<Integer>> tree1 = buildTree(edges1, n1);
        List<List<Integer>> tree2 = buildTree(edges2, n2);

        boolean[] isAtEvenLevel = new boolean[n1];
        int[] result = new int[n1];

        int evenNodesInTree1 = bfsForTree1(tree1, isAtEvenLevel);
        int oddNodesInTree1 = n1 - evenNodesInTree1;

        int evenNodesInTree2 = bfsForTree2(tree2);
        int oddNodesInTree2 = n2 - evenNodesInTree2;
        int bestOptionFromTree2 = Math.max(evenNodesInTree2, oddNodesInTree2);

        for(int i=0;i<n1;i++){
            int nodes = bestOptionFromTree2;

            if(isAtEvenLevel[i]) nodes += evenNodesInTree1;
            else nodes += oddNodesInTree1;

            result[i] = nodes;
        }
        return result;

    }

    // It will mark all nodes at even level from tree1 and return the even number of nodes
    private int bfsForTree1(List<List<Integer>> tree1, boolean[] isAtEvenLevel){
        
        int startNode = 0, evenNodes = 0, currLevel = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        boolean[] visited = new boolean[tree1.size()];
        visited[startNode] = true;

        while (!queue.isEmpty()) {
            int n = queue.size();
            for(int i=0;i<n;i++){
                int node = queue.poll();
                if(currLevel % 2 == 0){
                    isAtEvenLevel[node] = true;
                    evenNodes++;
                }
                for(int adjNode : tree1.get(node)){
                    if(visited[adjNode]) continue;
                    queue.add(adjNode);
                    visited[adjNode] = true;
                }
            }
            currLevel++;
        }
        return evenNodes;
    }

    // It will return the total number of Even nodes
    private int bfsForTree2(List<List<Integer>> tree2){
        
        int startNode = 0, evenNodes = 0, currLevel = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        boolean[] visited = new boolean[tree2.size()];
        visited[startNode] = true;

        while (!queue.isEmpty()) {
            int n = queue.size();
            for(int i=0;i<n;i++){
                int node = queue.poll();
                if(currLevel % 2 == 0){
                    evenNodes++;
                }
                for(int adjNode : tree2.get(node)){
                    if(visited[adjNode]) continue;
                    queue.add(adjNode);
                    visited[adjNode] = true;
                }
            }
            currLevel++;
        }
        return evenNodes;
    }

    private List<List<Integer>> buildTree(int[][] edges, int totalNodes){

        List<List<Integer>> tree = new ArrayList<>();
        for(int i=0;i<totalNodes;i++) tree.add(new ArrayList<>());

        for(int[] edge : edges){
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }

        return tree;
    }
}