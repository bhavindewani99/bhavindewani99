class Solution {
    public int lengthAfterTransformations(String input, int transformations) {
        // Frequency array to count occurrences of each character (a-z)
        int[] freq = new int[26];
        int MOD = 1_000_000_007;

        // Count frequency of each character in the input string
        for (char ch : input.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Perform the transformation t times
        for (int i = 0; i < transformations; i++) {
            int[] updatedFreq = new int[26];

            for (int j = 0; j < 26; j++) {
                if (freq[j] == 0) continue;

                if (j == 25) {
                    // 'z' becomes 'a' and 'b'
                    updatedFreq[0] = (updatedFreq[0] + freq[j]) % MOD;
                    updatedFreq[1] = (updatedFreq[1] + freq[j]) % MOD;
                } else {
                    // Other letters shift to the next character
                    updatedFreq[j + 1] = (updatedFreq[j + 1] + freq[j]) % MOD;
                }
            }

            freq = updatedFreq;
        }

        // Calculate total length of string after transformations
        int totalLength = 0;
        for (int count : freq) {
            totalLength = (totalLength + count) % MOD;
        }

        return totalLength;
    }
}
