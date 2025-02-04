import java.util.*;

class Solution {
    public int minimizeXor(int num1, int num2) {
        int setBits = Integer.bitCount(num2); // Count number of 1s in num2

        List<Integer> setBitPositions = new ArrayList<>();
        int index = 0; // Bit positions are 0-based
        int tempNum1 = num1;
        while (tempNum1 > 0) {
            if ((tempNum1 & 1) != 0) setBitPositions.add(index);
            tempNum1 >>= 1;
            index++;
        }

        int result = 0;
        index = 0; // Start from the 0th bit
        while (setBits > 0) {
            int curr = 0;
            if (!setBitPositions.isEmpty()) {
                curr = 1 << setBitPositions.remove(setBitPositions.size() - 1);
            } else {
                while ((result & (1 << index)) != 0) index++; // Find next available bit
                curr = 1 << index++;
            }
            result |= curr;
            setBits--;
        }
        return result;
    }
}
