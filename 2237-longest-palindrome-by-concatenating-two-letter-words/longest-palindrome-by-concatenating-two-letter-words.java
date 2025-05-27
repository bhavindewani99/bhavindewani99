/**
 * Intuition:
 * 1. We aim to form the longest possible palindrome by pairing words and their reverses.
 * 2. Symmetric words (like "gg") can be used in pairs or possibly one in the center if unpaired.
 */

class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> freqMap = new HashMap<>();
        int maxLength = 0;
        boolean hasMiddle = false;

        // Count frequency of each word
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        for (String word : freqMap.keySet()) {
            String reversed = new StringBuilder(word).reverse().toString();

            if (!word.equals(reversed)) {
                // Pair asymmetric word with its reverse
                if (freqMap.containsKey(reversed)) {
                    int pairCount = Math.min(freqMap.get(word), freqMap.get(reversed));
                    maxLength += pairCount * 4;
                    freqMap.put(word, freqMap.get(word) - pairCount);
                    freqMap.put(reversed, freqMap.get(reversed) - pairCount);
                }
            } else {
                // Word is symmetric (e.g., "gg", "aa")
                int count = freqMap.get(word);
                maxLength += (count / 2) * 4;
                // If there's one left, it can be used in the center
                if (count % 2 == 1) {
                    hasMiddle = true;
                }
            }
        }

        // Add 2 if we have a symmetric word left to place in the middle
        return hasMiddle ? maxLength + 2 : maxLength;
    }
}
