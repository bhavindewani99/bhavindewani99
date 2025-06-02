class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {

        if(node1==node2) return node1;
        
        int minDistance = Integer.MAX_VALUE, resultNode = -1;
        Map<Integer, Integer> visited1 = new HashMap<>();
        Map<Integer, Integer> visited2 = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(node1, 0, node1));
        queue.offer(new Pair(node2, 0, node2));

        while (!queue.isEmpty()) {
            int currNode = queue.peek().node, currDist = queue.peek().distance, sourceNode = queue.peek().sourceNode;
            queue.poll();

            //System.out.println("node is "+currNode+" distance is "+currDist+" sourceNode is "+sourceNode);

            if(sourceNode == node1){
                if(visited2.containsKey(currNode)){
                    int maxDistance = Math.max(currDist, visited2.get(currNode));
                    if(maxDistance < minDistance){
                        minDistance = maxDistance;
                        resultNode = currNode;
                    }else if(maxDistance == minDistance){
                        resultNode = Math.min(resultNode, currNode);
                    }
                }
                visited1.put(currNode, currDist);
                if(edges[currNode]!=-1 && visited1.containsKey(edges[currNode])==false){
                    queue.offer(new Pair(edges[currNode], currDist+1, sourceNode));
                }
            }else{
                if(visited1.containsKey(currNode)){
                    int maxDistance = Math.max(currDist, visited1.get(currNode));
                    if(maxDistance < minDistance){
                        minDistance = maxDistance;
                        resultNode = currNode;
                    }else if(maxDistance == minDistance){
                        resultNode = Math.min(resultNode, currNode);
                    }
                }
                visited2.put(currNode, currDist);
                if(edges[currNode]!=-1 && visited2.containsKey(edges[currNode])==false){
                    queue.offer(new Pair(edges[currNode], currDist+1, sourceNode));
                }
            }
            
        }
        return resultNode;
    }


    class Pair{
        int node, distance, sourceNode;
        Pair(int node, int distance, int sourceNode){
            this.node = node;
            this.distance = distance;
            this.sourceNode = sourceNode;
        }
    }
}