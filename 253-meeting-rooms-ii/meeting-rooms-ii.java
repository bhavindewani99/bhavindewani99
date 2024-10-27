class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return a[0] - b[0];
            }
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int res = 0;
        for(int i=0;i<intervals.length;i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            System.out.print(start+" "+end+" ");
            while(!pq.isEmpty() && pq.peek()<=start) pq.poll();
            pq.offer(end);
            res = Math.max(res, pq.size()); 
        }
        return res;
    }
}