class Solution {
    public int[] sortByBits(int[] arr) {
        // Convert int[] to Integer[] for sorting with a comparator
        Integer[] boxedArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        Arrays.sort(boxedArr, (a, b) -> {
            int cnt1 = countSetBits(a); // Custom bit count for 'a'
            int cnt2 = countSetBits(b); // Custom bit count for 'b'
            
            // Compare based on number of set bits, then by value
            if (cnt1 == cnt2) return Integer.compare(a, b);
            return Integer.compare(cnt1, cnt2);
        });

        // Convert Integer[] back to int[]
        return Arrays.stream(boxedArr).mapToInt(Integer::intValue).toArray();
    }

    // Custom method to count set bits
    private int countSetBits(int num) {
        int count = 0;
        while (num > 0) {
            count += (num & 1); // Increment if the last bit is 1
            num >>= 1; // Right shift to check the next bit
        }
        return count;
    }
}
