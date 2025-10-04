class Solution {
    private Map<String, Boolean> memo = new HashMap<>();

    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) return true;
        return recursion(s1, s2);
    }

    private boolean recursion(String s1, String s2) {
        String key = s1 + "_" + s2;
        if (memo.containsKey(key)) return memo.get(key);

        if (s1.equals(s2)) {
            memo.put(key, true);
            return true;
        }

        int n = s1.length();
        for (int i = 1; i < n; i++) {
            // No swap
            if (recursion(s1.substring(0, i), s2.substring(0, i)) &&
                recursion(s1.substring(i), s2.substring(i))) {
                memo.put(key, true);
                return true;
            }
            // Swap
            if (recursion(s1.substring(0, i), s2.substring(n - i)) &&
                recursion(s1.substring(i), s2.substring(0, n - i))) {
                memo.put(key, true);
                return true;
            }
        }

        memo.put(key, false);
        return false;
    }
}
