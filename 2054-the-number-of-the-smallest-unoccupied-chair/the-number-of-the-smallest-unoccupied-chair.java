class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        
        int arrT = times[targetFriend][0];
        int leavingTime = times[targetFriend][1];
        Arrays.sort(times, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                if(a[0]==b[0]) return a[1]-b[1];
                return a[0]-b[0];
            }
        });
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.time - b.time);
        PriorityQueue<Integer> availableChairs = new PriorityQueue<>();
        for(int i=0;i<times.length;i++) availableChairs.offer(i);

        for(int i=0;i<times.length;i++){
            int currTime = times[i][0];
            int currLeavingTime = times[i][1];
            while(!pq.isEmpty() && pq.peek().time<=currTime){
                Pair pair = pq.poll();
                availableChairs.offer(pair.chair);
            }
            if(currTime==arrT && currLeavingTime==leavingTime) return availableChairs.peek();

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