class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int stops = 0;
        int i =0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);

        while(startFuel<target){
            while(i<stations.length && startFuel>=stations[i][0]){
                pq.offer(stations[i++][1]);
            }
            if(pq.isEmpty()) return -1;
            startFuel += pq.poll();
            stops++;
        }
        return stops;
    }
}