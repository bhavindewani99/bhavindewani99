class Solution {
    public int minCostConnectPoints(int[][] points) {
        
        Set<Integer> visitedNodes = new HashSet<>();
        int cost = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]); // Cost, Node
        pq.add(new int[]{0, 0});

        while(!pq.isEmpty()){
            int currCost = pq.peek()[0];
            int node = pq.peek()[1];
            pq.poll();
            if(visitedNodes.contains(node)) continue;
            cost += currCost;
            visitedNodes.add(node);
            

            for(int i=0;i<points.length;i++){
                if(visitedNodes.contains(i)) continue;
                int newCost = Math.abs(points[node][0] - points[i][0]) + Math.abs(points[node][1] - points[i][1]);
                pq.offer(new int[]{newCost, i});
            }
        }

        return cost;
    }
}