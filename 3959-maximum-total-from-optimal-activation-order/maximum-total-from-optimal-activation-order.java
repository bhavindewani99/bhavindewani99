class Solution {
    public long maxTotal(int[] value, int[] limit) {
        int n = value.length;

        Deque<Pair> activeOrder = new ArrayDeque<>();
        PriorityQueue<Pair> heap = new PriorityQueue<>(
            (a, b) -> a.limit == b.limit ? b.value - a.value : a.limit - b.limit
        );

        for (int i = 0; i < n; i++) {
            heap.add(new Pair(value[i], limit[i]));
        }

        long sum = 0;
        while (!heap.isEmpty() && heap.peek().limit > activeOrder.size()) {
            Pair p = heap.poll();
            sum += p.value;
            activeOrder.add(p);

            while (!heap.isEmpty() && heap.peek().limit <= activeOrder.size()) heap.poll();
            while (!activeOrder.isEmpty() && activeOrder.getFirst().limit <= activeOrder.size()) {
                activeOrder.removeFirst();
            }
        }
        return sum;
    }

    class Pair {
        int value, limit;
        Pair(int value, int limit) { this.value = value; this.limit = limit; }
    }
}
