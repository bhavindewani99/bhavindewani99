class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i:nums) pq.offer(i*1l);
        long result =0;

        while(k>0){
            long curr = pq.poll();
            result += curr;
            curr = Math.ceilDiv(curr, 3) * 1l;
            pq.offer(curr);
            k--;
        }

        return result;
    }
}