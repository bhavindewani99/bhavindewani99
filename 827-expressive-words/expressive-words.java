class Solution {
    public int expressiveWords(String s, String[] words) {
        int result = 0;
        for (String word : words) {
            if (canExtend(word, s)) result++;
        }
        return result;
    }

    private boolean canExtend(String word, String s) {
        int i = 0, j = 0;
        int m = word.length(), n = s.length();

        while (i < m && j < n) {
            if (word.charAt(i) != s.charAt(j)) return false;

            // Count group length in word
            int iStart = i;
            while (i < m && word.charAt(i) == word.charAt(iStart)) i++;
            int wordGroupLen = i - iStart;

            // Count group length in s
            int jStart = j;
            while (j < n && s.charAt(j) == s.charAt(jStart)) j++;
            int sGroupLen = j - jStart;

            // Validate stretchiness
            if (sGroupLen < 3 && wordGroupLen != sGroupLen) return false;
            if (wordGroupLen > sGroupLen) return false;
        }

        return i == m && j == n;
    }
}
