import java.util.*;

class Solution {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        List<Integer> result = new ArrayList<>();

        // Edge case: if k is negative, return empty result
        if (k < 0) {
            return result;
        }

        // Find all positions of substring a in s
        List<Integer> aIndices = findIndicesWithRollingHash(s, a);
        // Find all positions of substring b in s
        List<Integer> bIndices = findIndicesWithRollingHash(s, b);

        int ap = 0, bp = 0;  // Two pointers for aIndices and bIndices

        // Use two-pointer approach to compare indices
        while (ap < aIndices.size() && bp < bIndices.size()) {
            int ai = aIndices.get(ap);
            int bi = bIndices.get(bp);

            if (Math.abs(ai - bi) <= k) {
                result.add(ai);  // Add only the index of 'a'
                ap++;  // Move a pointer to avoid redundant checks
            } else if (ai < bi) {
                ap++;  // If ai is less than bi, move the a pointer forward
            } else {
                bp++;  // If bi is less than ai, move the b pointer forward
            }
        }

        return result;  // Return the list of beautiful indices
    }

    private List<Integer> findIndicesWithRollingHash(String s, String t) {
        List<Integer> indices = new ArrayList<>();
        int sLen = s.length(), tLen = t.length();
        if (tLen > sLen) return indices;  // Return empty if t is longer than s
        
        long targetHash = 0, currentHash = 0;
        long base = 26;  // We're assuming lowercase English letters, hence base 26
        long basePow = 1;  // Will store base^(tLen-1) for rolling hash

        // Calculate base^(tLen-1) for the rolling hash mechanism
        for (int i = 1; i < tLen; i++) {
            basePow *= base;
        }
        
        // Compute the hash of the target substring 't' and the initial hash of 's'
        for (int i = 0; i < tLen; i++) {
            targetHash = targetHash * base + (t.charAt(i) - 'a');
            currentHash = currentHash * base + (s.charAt(i) - 'a');
        }
        
        // Slide over the string 's' to find matches
        for (int i = 0; i <= sLen - tLen; i++) {
            // If the current hash matches the target hash, it's a potential match
            if (currentHash == targetHash) {
                indices.add(i);  // Found a match at position i
            }
            
            // Update the current hash to the next window (rolling hash)
            if (i + tLen < sLen) {
                currentHash = (currentHash - (s.charAt(i) - 'a') * basePow) * base + (s.charAt(i + tLen) - 'a');
            }
        }
        
        return indices;
    }
}
