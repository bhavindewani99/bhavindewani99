class Solution {
    public int minGroups(int[][] intervals) {

        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] a , int[] b){
                if(a[0]==b[0]){
                    return a[1]-b[1];
                }
                return a[0]-b[0];
            }
        });
        int res = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int[] interval : intervals){
            int start = interval[0];
            int end = interval[1];
            while(!pq.isEmpty() && pq.peek()<start) pq.poll();
            pq.offer(end);
            res = Math.max(res, pq.size());
        }

        return res;
    }
}