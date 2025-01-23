class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] count = new int[n + 1];

        // Process shifts
        for (int i = 0; i < shifts.length; i++) {
            int start = shifts[i][0], end = shifts[i][1];
            int direction = shifts[i][2] == 1 ? 1 : -1;
            count[start] += direction;
            if (end + 1 < count.length) count[end + 1] -= direction;
        }

        // Prefix sum to calculate cumulative shifts
        for (int i = 1; i <= n; i++) count[i] += count[i - 1];

        // Build result
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int currCount = (c - 'a' + count[i]) % 26;
            if(currCount<0) currCount += 26;
            char shiftedc = (char) ('a' + currCount);
            result.append(shiftedc);
        }

        return result.toString();
    }
}
