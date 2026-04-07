class Solution {
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int x : arr) {
            count.put(x, count.getOrDefault(x, 0) + 1);
        }

        // Convert to Integer array to use a custom comparator
        Integer[] sortedArr = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) sortedArr[i] = arr[i];
        
        // Sort by absolute value: e.g., [-2, 2, -4, 4]
        Arrays.sort(sortedArr, Comparator.comparingInt(Math::abs));

        for (int x : sortedArr) {
            if (count.get(x) == 0) continue; // Already paired
            
            int target = 2 * x;
            if (count.getOrDefault(target, 0) <= 0) return false; // No pair found

            // Reduce counts for both the number and its double
            count.put(x, count.get(x) - 1);
            count.put(target, count.get(target) - 1);
        }

        return true;
    }
}
