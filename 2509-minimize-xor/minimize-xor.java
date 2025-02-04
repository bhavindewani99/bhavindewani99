class Solution {
    public int minimizeXor(int num1, int num2) {
        int setBits = Integer.bitCount(num2); // Count 1s in num2
        int result = 0;

        // Step 1: Use bits from num1 where possible
        for (int i = 31; i >= 0 && setBits > 0; i--) {
            if ((num1 & (1 << i)) != 0) { // If bit is set in num1
                result |= (1 << i);
                setBits--;
            }
        }

        // Step 2: If more bits need to be set, set the smallest bits
        for (int i = 0; i < 32 && setBits > 0; i++) {
            if ((result & (1 << i)) == 0) { // If bit is NOT set
                result |= (1 << i);
                setBits--;
            }
        }

        return result;
    }
}
