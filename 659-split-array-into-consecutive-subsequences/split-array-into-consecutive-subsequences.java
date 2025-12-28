class Solution {
    public boolean isPossible(int[] nums) {

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> a.element != b.element ? a.element - b.element : a.size - b.size
        );

        for (int num : nums) {

            // Any subsequence ending before (num - 1) can never be extended now.
            // It must already have length >= 3.
            while (!pq.isEmpty() && pq.peek().element < num - 1) {
                if (pq.poll().size < 3) return false;
            }

            // Extend the shortest subsequence that ends at num - 1, if it exists.
            if (!pq.isEmpty() && pq.peek().element == num - 1) {
                Pair p = pq.poll();
                p.element = num;
                p.size++;
                pq.offer(p);
            } else {
                // Otherwise start a new subsequence at num
                pq.offer(new Pair(num, 1));
            }
        }

        // Finalize remaining subsequences
        while (!pq.isEmpty()) {
            if (pq.poll().size < 3) return false;
        }

        return true;
    }

    class Pair {
        int element, size;
        Pair(int element, int size) {
            this.element = element;
            this.size = size;
        }
    }
}
