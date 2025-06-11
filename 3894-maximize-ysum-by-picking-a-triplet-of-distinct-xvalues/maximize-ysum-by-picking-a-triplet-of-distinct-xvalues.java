class Solution {
    public int maxSumDistinctTriplet(int[] x, int[] y) {
        
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<x.length;i++){
            int maxYVal = Math.max(map.getOrDefault(x[i], 0), y[i]);
            map.put(x[i], maxYVal);
        }

        if(map.size()<3) return -1;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int yValues : map.values()){
            if(pq.isEmpty() || pq.size() < 3) pq.add(yValues);
            else if(pq.peek() < yValues) {
                pq.poll();
                pq.add(yValues);
            }
        }

        int result = 0;
        while(!pq.isEmpty()) result += pq.poll();

        return result;
    }
}