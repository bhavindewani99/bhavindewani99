import java.util.*;

class Solution {
    private Map<String, Boolean> memo = new HashMap<>();

    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        return recursion(s1, s2);
    }

    private boolean recursion(String s1, String s2) {
        String key = s1 + "_" + s2;
        if (memo.containsKey(key)) return memo.get(key);

        // base case
        if (s1.equals(s2)) {
            memo.put(key, true);
            return true;
        }
        if (s1.length() == 1) {  // stop when length is 1
            memo.put(key, false);
            return false;
        }

        // prune: if characters don't match in frequency, return false
        char[] a = s1.toCharArray(), b = s2.toCharArray();
        Arrays.sort(a); Arrays.sort(b);
        if (!Arrays.equals(a, b)) {
            memo.put(key, false);
            return false;
        }

        int n = s1.length();
        for (int i = 1; i < n; i++) {
            // Case 1: no swap
            if (recursion(s1.substring(0, i), s2.substring(0, i)) &&
                recursion(s1.substring(i), s2.substring(i))) {
                memo.put(key, true);
                return true;
            }

            // Case 2: swap
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
