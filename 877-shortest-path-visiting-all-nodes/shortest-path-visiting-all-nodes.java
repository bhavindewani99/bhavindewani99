class Solution {
    public int shortestPathLength(int[][] graph) {
        
        int n = graph.length;
        if(n==1) return 0;
        int finalState = (1 << n) -1;
        int path = 0;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][finalState+1];

        for(int i=0;i<n;i++){
            queue.offer(new int[] {i, 1<<i});
        }


        while(!queue.isEmpty()){
            int len = queue.size();
            path++;

            for(int j=0;j<len;j++){
                int node = queue.peek()[0];
                int bitState = queue.peek()[1];
                queue.poll();

                for(int adjNode : graph[node]){
                    int newbitState = bitState | (1<<adjNode);

                    if(finalState == newbitState) return path;

                    if(visited[adjNode][newbitState]) continue;
                    visited[adjNode][newbitState] = true;

                    queue.offer(new int[] {adjNode, newbitState});
                }
                
            }
        }
        return path;
    }
}