class Solution {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        if (k == 1 || n == k) return 0;

        PriorityQueue<Long> minHeap = new PriorityQueue<>(Collections.reverseOrder()); // for smallest k-1 sums
        PriorityQueue<Long> maxHeap = new PriorityQueue<>(); // for largest k-1 sums

        for (int i = 0; i < n - 1; i++) {
            long curr = weights[i] + weights[i + 1];

            // Maintain smallest (k-1) sums
            minHeap.offer(curr);
            if (minHeap.size() > k - 1) minHeap.poll();

            // Maintain largest (k-1) sums
            maxHeap.offer(curr);
            if (maxHeap.size() > k - 1) maxHeap.poll();
        }

        long minSum = 0, maxSum = 0;

        while (!minHeap.isEmpty()) minSum += minHeap.poll();
        while (!maxHeap.isEmpty()) maxSum += maxHeap.poll();

        return maxSum - minSum;
    }
}
