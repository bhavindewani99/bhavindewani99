import java.util.*;

class Solution {
    public String rearrangeString(String s, int k) {
        if (k == 0) return s;  // If k is 0, no need to rearrange

        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> b.freq - a.freq);
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            maxHeap.offer(new Pair(entry.getKey(), entry.getValue()));
        }

        Queue<Pair> waitQueue = new LinkedList<>();
        StringBuilder result = new StringBuilder();

        while (!maxHeap.isEmpty()) {
            Pair current = maxHeap.poll();
            result.append(current.c);
            current.freq--;

            // Add current to waitQueue to respect `k` distance
            waitQueue.offer(current);
            if (waitQueue.size() >= k) {
                Pair front = waitQueue.poll();
                if (front.freq > 0) {
                    maxHeap.offer(front); // Re-add if still has remaining frequency
                }
            }
        }

        return result.length() == s.length() ? result.toString() : "";
    }

    class Pair {
        char c;
        int freq;
        Pair(char c, int freq) {
            this.c = c;
            this.freq = freq;
        }
    }
}
