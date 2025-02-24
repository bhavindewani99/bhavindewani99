class Solution {
    public boolean isMatch(String s, String p) {
        Map<String, Boolean> memo = new HashMap<>();
        return isMatchRecursive(s, 0, p, 0, memo);
    }

    private boolean isMatchRecursive(String s, int i, String p, int j, Map<String, Boolean> memo) {
        
        if (i == s.length() && j == p.length()) return true;
        
        if (j == p.length()) return false;

        String key = i + "," + j;
        if (memo.containsKey(key)) return memo.get(key);

        // Check if the current characters match or if pattern character is '.'
        boolean isFirstMatch = (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));

        boolean result = false;

        // Check for '*' in the pattern
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            // Try skipping the '*' or use it to match multiple preceding elements
            result = isMatchRecursive(s, i, p, j + 2, memo) || (isFirstMatch && isMatchRecursive(s, i + 1, p, j, memo));
        } else {
            // Proceed normally if characters match
            result = isFirstMatch && isMatchRecursive(s, i + 1, p, j + 1, memo);
        }

        // Memoize the result
        memo.put(key, result);
        return result;
    }
}
