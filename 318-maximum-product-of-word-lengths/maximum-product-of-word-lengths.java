class Solution {
    public int maxProduct(String[] words) {
        int ans = 0;
        int n = words.length;
        int[][] freq = new int[n][26];

        for (int i = 0; i < n; i++) {
            for (char c : words[i].toCharArray()) {
                freq[i][c - 'a'] = 1;
            }
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (check(freq[i], freq[j])) {
                    ans = Math.max(ans, words[i].length() * words[j].length());
                }
            }
        }

        return ans;
    }

    private boolean check(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] == 1 && b[i] == 1) return false;
        }
        return true;
    }
}