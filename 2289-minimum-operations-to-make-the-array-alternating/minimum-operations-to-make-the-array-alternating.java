class Solution {

// We want to make all even-indexed elements the same and all odd-indexed elements the same,
// while minimizing the number of changes. We find the two most frequent numbers at even and odd positions.
// If the most frequent ones are different, we use them. If they are the same, we try the next best alternative.

    class Pair {
        int element, frequency;
        Pair(int element, int frequency) {
            this.element = element;
            this.frequency = frequency;
        }
    }

    public int minimumOperations(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;

        int evenLen = (n + 1) / 2;
        int oddLen = n / 2;

        Map<Integer, Integer> evenFreq = new HashMap<>();
        Map<Integer, Integer> oddFreq = new HashMap<>();

        // Count frequency of elements at even and odd indices
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0)
                evenFreq.put(nums[i], evenFreq.getOrDefault(nums[i], 0) + 1);
            else
                oddFreq.put(nums[i], oddFreq.getOrDefault(nums[i], 0) + 1);
        }

        // Get top 2 frequent elements from even and odd positions
        List<Pair> topEven = getTopTwo(evenFreq);
        List<Pair> topOdd = getTopTwo(oddFreq);

        Pair even1 = topEven.get(0), even2 = topEven.size() > 1 ? topEven.get(1) : new Pair(-1, 0);
        Pair odd1 = topOdd.get(0), odd2 = topOdd.size() > 1 ? topOdd.get(1) : new Pair(-1, 0);

        // If top even and odd elements are different, no conflict
        if (even1.element != odd1.element) {
            return (evenLen - even1.frequency) + (oddLen - odd1.frequency);
        } else {
            // Try combinations avoiding same value in even and odd
            int option1 = (evenLen - even1.frequency) + (oddLen - odd2.frequency);
            int option2 = (evenLen - even2.frequency) + (oddLen - odd1.frequency);
            return Math.min(option1, option2);
        }
    }

    // Helper to get top 2 frequent elements
    private List<Pair> getTopTwo(Map<Integer, Integer> freqMap) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.frequency - b.frequency);

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            pq.offer(new Pair(entry.getKey(), entry.getValue()));
            if (pq.size() > 2) pq.poll(); // Keep only top 2
        }

        List<Pair> result = new ArrayList<>(pq);
        result.sort((a, b) -> b.frequency - a.frequency); // Descending order
        return result;
    }
}
