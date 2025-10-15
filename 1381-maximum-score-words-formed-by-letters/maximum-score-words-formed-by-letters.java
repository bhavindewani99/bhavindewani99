class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] freq = new int[26];
        for (char c : letters) freq[c - 'a']++;
        return backtrack(words, freq, score, 0);
    }

    private int backtrack(String[] words, int[] freq, int[] score, int index) {
        if (index == words.length) return 0;

        // Option 1: skip this word
        int notTake = backtrack(words, freq, score, index + 1);

        // Option 2: try taking this word
        String word = words[index];
        int wordScore = 0;
        boolean canTake = true;

        // consume letters
        for (char c : word.toCharArray()) {
            freq[c - 'a']--;
            if (freq[c - 'a'] < 0) canTake = false;
            wordScore += score[c - 'a'];
        }

        int take = 0;
        if (canTake) {
            take = wordScore + backtrack(words, freq, score, index + 1);
        }

        // backtrack: restore frequencies
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }

        return Math.max(take, notTake);
    }
}
