class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        
        Arrays.sort(trips, (a,b) -> a[1] - b[1]);
        int currCapacity = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.end-b.end);

        for(int[] trip : trips){
            while(!pq.isEmpty() && pq.peek().end<=trip[1]){
                currCapacity -= pq.poll().passengers;
            }
            if(currCapacity + trip[0] > capacity) return false;
            currCapacity += trip[0];
            pq.offer(new Pair(trip[0], trip[1], trip[2]));
        }
        return true;
    }

    class Pair{
        int passengers, start, end;
        Pair(int passengers, int start, int end){
            this.passengers = passengers;
            this.start = start;
            this.end = end;
        }
    }
}