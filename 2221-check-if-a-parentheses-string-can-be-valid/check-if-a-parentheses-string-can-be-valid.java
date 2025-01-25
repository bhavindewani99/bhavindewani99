class Solution {
    public boolean canBeValid(String s, String locked) {
        if (s.length() % 2 != 0) return false; // Odd length can't be valid

        int open = 0, balance = 0;

        // Left-to-right pass: Check balance of '(' and potential fixes
        for (int i = 0; i < s.length(); i++) {
            if (locked.charAt(i) == '0' || s.charAt(i) == '(') {
                open++;
            } else {
                open--;
            }
            balance++;
            if (open < 0) return false; // Too many ')'
        }

        // Right-to-left pass: Check balance of ')' and potential fixes
        open = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (locked.charAt(i) == '0' || s.charAt(i) == ')') {
                open++;
            } else {
                open--;
            }
            if (open < 0) return false; // Too many '('
        }

        return true;
    }
}
