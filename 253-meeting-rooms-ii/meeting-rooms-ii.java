class Solution {
    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if(a[0]==b[0]){
                    return a[1]-b[1];
                }
                return a[0] - b[0]; // Compare the second element of each interval
            }
        });
        int res= 1;
        pq.offer(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            if(pq.peek()[1]>intervals[i][0]){
                pq.offer(intervals[i]);
            }else{
                while(!pq.isEmpty() && pq.peek()[1]<=intervals[i][0]){
                    pq.poll();
                }
                pq.offer(intervals[i]);
            }
            res = Math.max(res,pq.size());
        }
        return res;


    }
}