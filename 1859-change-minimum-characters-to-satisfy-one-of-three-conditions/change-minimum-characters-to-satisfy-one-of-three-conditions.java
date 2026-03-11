class Solution {
    public int minCharacters(String a, String b) {
        
        int m = a.length(), n = b.length();
        int[] countA = new int[26], countB = new int[26];
        int[] prefixA = new int[26], prefixB = new int[26];
        int result = Integer.MAX_VALUE;

        for (char c : a.toCharArray()) countA[c - 'a']++;
        for (char c : b.toCharArray()) countB[c - 'a']++;

        prefixA[0] = countA[0];
        prefixB[0] = countB[0];

        for (int i = 1; i < 26; i++) {
            prefixA[i] = prefixA[i - 1] + countA[i];
            prefixB[i] = prefixB[i - 1] + countB[i];
        }

        for (int i = 0; i < 26; i++) {

            // condition 3: both strings consist of one distinct letter
            result = Math.min(result, (m - countA[i]) + (n - countB[i]));

            // condition 1 and 2
            if (i < 25) {
                // all chars in a <= i, all chars in b > i
                result = Math.min(result, (m - prefixA[i]) + prefixB[i]);

                // all chars in b <= i, all chars in a > i
                result = Math.min(result, (n - prefixB[i]) + prefixA[i]);
            }
        }

        return result;
    }
}