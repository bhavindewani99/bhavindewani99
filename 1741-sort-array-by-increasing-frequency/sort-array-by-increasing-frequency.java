import java.util.*;

class Solution {
    public int[] frequencySort(int[] nums) {
        int n = nums.length;

        // Step 1: Count the frequency of each number
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Sort the numbers based on frequency and value
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        Collections.sort(list, (a, b) -> {
            int freqA = map.get(a);
            int freqB = map.get(b);

            // Sort by frequency ascending, and by value descending for ties
            if (freqA == freqB) {
                return b - a; // Descending order for values
            }
            return freqA - freqB; // Ascending order for frequency
        });

        // Step 3: Convert back to an array
        for (int i = 0; i < n; i++) {
            nums[i] = list.get(i);
        }

        return nums;
    }
}
