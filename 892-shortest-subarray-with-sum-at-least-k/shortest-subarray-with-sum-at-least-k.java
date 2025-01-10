class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int res = Integer.MAX_VALUE;
        long sum = 0; // Use long to handle large sums
        Deque<Pair> deque = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum >= k) {
                res = Math.min(res, i + 1);
            }
            
            // remove the initial prefix sum
            while (!deque.isEmpty() && sum - deque.peekFirst().prefixSum >= k) {
                res = Math.min(res, i - deque.pollFirst().index);
            }

            // we have to store prefixSum in increasing order
            while (!deque.isEmpty() && deque.peekLast().prefixSum >= sum) {
                deque.pollLast();
            }

            deque.offer(new Pair(sum, i));
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    class Pair {
        long prefixSum;
        int index;

        Pair(long prefixSum, int index) {
            this.prefixSum = prefixSum;
            this.index = index;
        }
    }
}
