class Solution {
    public int nthUglyNumber(int n) {
        return returnNthUglyNumber(n);
    }

    // Heap Solution
    private int returnNthUglyNumber(int n){
        Set<Long> visited = new HashSet<>();
        PriorityQueue<Long> heap = new PriorityQueue<>();
        heap.add(1l);
        n-=1;
        while(n>0){
            long number = heap.poll();
            if (visited.add(number * 2)) {
                heap.offer(number * 2);
            }
            if (visited.add(number * 3)) {
                heap.offer(number * 3);
            }
            if (visited.add(number * 5)) {
                heap.offer(number * 5);
            }
            n--;
        }
        return (heap.poll().intValue());
    }
}