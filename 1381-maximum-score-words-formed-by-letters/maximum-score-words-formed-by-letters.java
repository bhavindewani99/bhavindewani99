class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] freq = new int[26];
        for (char c : letters) freq[c - 'a']++;
        return backtrack(words, freq, score, 0);
    }

    private int backtrack(String[] words, int[] freq, int[] score, int index) {
        if (index == words.length) return 0;

        // Option 1: skip the current word
        int notTake = backtrack(words, freq, score, index + 1);

        // Option 2: take the current word (if possible)
        String word = words[index];
        int wordScore = 0;
        boolean canTake = true;
        int[] temp = Arrays.copyOf(freq, 26);

        for (char c : word.toCharArray()) {
            temp[c - 'a']--;
            if (temp[c - 'a'] < 0) {
                canTake = false;
                break;
            }
            wordScore += score[c - 'a'];
        }

        int take = 0;
        if (canTake) take = wordScore + backtrack(words, temp, score, index + 1);

        return Math.max(take, notTake);
    }
}
