class Solution {
    int res = 1; // Count "0" immediately

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        
        
        boolean[] used = new boolean[10];
        backtracking(0, 0, used, n);
        return res;
    }

    private void backtracking(long curr, int digitCount, boolean[] used, int n) {
        // Base case: Stop if we've reached the maximum allowed digits
        if (digitCount == n) return;

        for (int i = 0; i < 10; i++) {
            // Rule: Multi-digit numbers cannot start with 0
            if (digitCount > 0 && i == 0 && curr == 0) continue; 
            // Better rule: If we are at the first position, don't pick 0
            // (Since 0 is already counted in the initial res = 1)
            if (digitCount == 0 && i == 0) continue;

            if (!used[i]) {
                used[i] = true;
                res++;
                backtracking(curr * 10 + i, digitCount + 1, used, n);
                used[i] = false; // Backtrack
            }
        }
    }
}
