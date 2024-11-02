class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
       
        Integer[] order = new Integer[times.length];
        for(int i=0;i<times.length;i++) order[i] = i;
        Arrays.sort(order, (a,b) -> Integer.compare(times[a][0], times[b][0]));
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.time - b.time);
        PriorityQueue<Integer> availableChairs = new PriorityQueue<>();
        for(int i=0;i<times.length;i++) availableChairs.offer(i);

        for(int i : order){
            int currTime = times[i][0];
            int currLeavingTime = times[i][1];
            
            while(!pq.isEmpty() && pq.peek().time<=currTime){
                Pair pair = pq.poll();
                availableChairs.offer(pair.chair);
            }
            if(i== targetFriend) return availableChairs.peek();
            pq.offer(new Pair(currLeavingTime, availableChairs.poll()));
        }
        return -1;
    }

    class Pair{
        int time, chair;
        Pair(int time, int chair){
            this.time = time;
            this.chair = chair;
        }
    }
}