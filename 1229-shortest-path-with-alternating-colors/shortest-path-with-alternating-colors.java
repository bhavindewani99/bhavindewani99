class Solution {
    int[] answer;
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        answer = new int[n];
        Arrays.fill(answer, -1);
        Map<Integer, List<int[]>> map = new HashMap<>();
        boolean[][] visited = new boolean[n][2];
        
        for(int i =0;i<n;i++){
            map.put(i, new ArrayList<>());
        }

        for(int[] edge : redEdges){
            map.get(edge[0]).add(new int[]{edge[1], 0}); // node, color
        }

        for(int[] edge : blueEdges){
            map.get(edge[0]).add(new int[]{edge[1], 1});  // node, color
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,-1,0}); // node, color, distance
        visited[0][0] = true;
        visited[0][1] = true;

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int node = curr[0], color = curr[1], dist = curr[2];

            if(answer[node] == -1) answer[node] = dist;

            for(int[] neig : map.get(node)){
                int nextNode = neig[0], nextColor = neig[1];

                if(color != nextColor && visited[nextNode][nextColor] == false){
                    visited[nextNode][nextColor] = true;
                    queue.offer(new int[]{nextNode, nextColor, dist+1});
                }
            }
        }

        return answer;

    }
}