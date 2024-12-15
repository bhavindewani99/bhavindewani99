import java.util.HashSet;

class Solution {
    public int longestRepeatingSubstring(String s) {
        int n = s.length();
        int left = 1, right = n;

        // Perform binary search on the possible length of the repeating substring
        while (left < right) {
            int mid = (left + right) / 2;
            if (hasRepeatingSubstring(s, mid)) {
                left = mid + 1; // We found a repeating substring of length mid, so try for a longer one
            } else {
                right = mid; // No repeating substring of length mid, try shorter ones
            }
        }
        
        return left - 1; // left will be the first length where no repeat exists, so the longest valid length is left - 1
    }

    private boolean hasRepeatingSubstring(String s, int length) {
        int n = s.length();
        if (length == 0) return false;

        long hash = 0;
        long base = 256; // Base for rolling hash
        long mod = (long) 1e9 + 7; // A large prime number for modulo to avoid overflow
        long baseL = 1; // This will be base^length % mod

        // Calculate base^length % mod
        for (int i = 0; i < length; i++) {
            baseL = (baseL * base) % mod;
        }

        HashSet<Long> seen = new HashSet<>();

        // Compute the hash for the first substring of length `length`
        for (int i = 0; i < length; i++) {
            hash = (hash * base + s.charAt(i)) % mod;
        }

        seen.add(hash);

        // Use rolling hash to check all other substrings of length `length`
        for (int i = length; i < n; i++) {
            // Remove the leftmost character and add the rightmost character to form a new substring hash
            hash = (hash * base - s.charAt(i - length) * baseL + s.charAt(i)) % mod;
            if (hash < 0) hash += mod; // Handle negative hash values

            // If the hash has been seen before, that means a duplicate substring exists
            if (seen.contains(hash)) {
                return true;
            }

            seen.add(hash);
        }

        return false; // No repeating substring of the given length found
    }
}
