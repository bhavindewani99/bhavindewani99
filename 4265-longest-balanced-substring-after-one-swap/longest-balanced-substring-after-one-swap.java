class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int[] ones = new int[n];
        int[] zeroes = new int[n];
        int[] pref = new int[n];

        // Standard prefix counts
        for (int i = 0; i < n; i++) {
            ones[i] = (i > 0 ? ones[i - 1] : 0) + (s.charAt(i) == '1' ? 1 : 0);
            zeroes[i] = (i > 0 ? zeroes[i - 1] : 0) + (s.charAt(i) == '0' ? 1 : 0);
            pref[i] = ones[i] - zeroes[i];
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        map.computeIfAbsent(0, k -> new ArrayList<>()).add(-1);

        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(pref[i], k -> new ArrayList<>()).add(i);
        }

        int ans = 0;
        int totalOnes = ones[n - 1];
        int totalZeroes = zeroes[n - 1];

        for (int end = 0; end < n; end++) {
            // Check for potential starts using current prefix sum, +2, and -2
            ans = Math.max(ans, solve(map.get(pref[end]), end, ones, zeroes, totalOnes, totalZeroes));
            ans = Math.max(ans, solve(map.get(pref[end] + 2), end, ones, zeroes, totalOnes, totalZeroes));
            ans = Math.max(ans, solve(map.get(pref[end] - 2), end, ones, zeroes, totalOnes, totalZeroes));
        }

        return ans;
    }

    int solve(List<Integer> list, int end, int[] ones, int[] zeroes, int totalOnes, int totalZeroes) {
        if (list == null) return 0;
        
        for (int startIdx : list) {
            // 'startIdx' is the index BEFORE the substring begins
            if (startIdx >= end) break;

            int one = ones[end] - (startIdx >= 0 ? ones[startIdx] : 0);
            int zero = zeroes[end] - (startIdx >= 0 ? zeroes[startIdx] : 0);
            int len = end - startIdx;

            // Case 1: Already balanced
            if (one == zero) return len;

            // Case 2: 2 extra zeros, need to swap a 0 for a 1 from outside
            if (zero == one + 2 && (totalOnes - one) > 0) return len;

            // Case 3: 2 extra ones, need to swap a 1 for a 0 from outside
            if (one == zero + 2 && (totalZeroes - zero) > 0) return len;
        }

        return 0;
    }
}
