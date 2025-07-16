class Solution {
    public int maximumLength(int[] nums) {
        int allOdd = 0;
        int allEven = 0;
        int alt1 = 0; // Even index → Even, Odd index → Odd
        int alt2 = 0; // Even index → Odd,  Odd index → Even

        // Pointers for alt1 and alt2 index tracking
        int alt1Idx = 0, alt2Idx = 0;

        for (int num : nums) {
            if (num % 2 == 0) allEven++;
            else allOdd++;

            // For alt1 pattern (even index → even, odd index → odd)
            if ((alt1Idx % 2 == 0 && num % 2 == 0) || (alt1Idx % 2 == 1 && num % 2 == 1)) {
                alt1++;
                alt1Idx++;
            }

            // For alt2 pattern (even index → odd, odd index → even)
            if ((alt2Idx % 2 == 0 && num % 2 == 1) || (alt2Idx % 2 == 1 && num % 2 == 0)) {
                alt2++;
                alt2Idx++;
            }
        }

        return Math.max(Math.max(allOdd, allEven), Math.max(alt1, alt2));
    }
}