import java.util.*;

class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        // Edge case: if desiredTotal is 0 or less, the first player wins immediately
        if (desiredTotal <= 0) return true;

        // Sum of all choosable numbers
        int maxTotal = (maxChoosableInteger * (maxChoosableInteger + 1)) / 2;
        if (maxTotal < desiredTotal) return false; // Not possible to reach desiredTotal

        Map<Integer, Boolean> memo = new HashMap<>();
        return canWin(0, desiredTotal, maxChoosableInteger, memo);
    }

    private boolean canWin(int usedNumbers, int desiredTotal, int maxChoosableInteger, Map<Integer, Boolean> memo) {
        if (memo.containsKey(usedNumbers)) {
            return memo.get(usedNumbers);
        }

        for (int i = 1; i <= maxChoosableInteger; i++) {
            int currentBit = 1 << i;
            if ((usedNumbers & currentBit) == 0) {
                // If choosing i reaches or exceeds desiredTotal, or the opponent cannot win in the next turn
                if (i >= desiredTotal || !canWin(usedNumbers | currentBit, desiredTotal - i, maxChoosableInteger, memo)) {
                    memo.put(usedNumbers, true);
                    return true;
                }
            }
        }

        memo.put(usedNumbers, false);
        return false;
    }
}
