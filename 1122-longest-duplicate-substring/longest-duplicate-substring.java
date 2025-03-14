class Solution {
    public String longestDupSubstring(String s) {
        int left = 1, right = s.length();
        String result = "";

        while (left <= right) {
            int mid = left + (right - left) / 2;
            String curr = getString(s, mid);

            if (!curr.equals("")) {
                result = curr;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    private String getString(String s, int length) {
        long base = 31, mod = (long) 1e9 + 7, hash = 0, pow = 1;
        Map<Long, Integer> map = new HashMap<>();

        // Precompute base^(length-1) for rolling hash
        for (int i = 1; i < length; i++) {
            pow = (pow * base) % mod;
        }

        // Compute initial hash for the first "length" characters
        for (int i = 0; i < length; i++) {
            hash = (hash * base + (s.charAt(i) - 'a')) % mod;
        }
        map.put(hash, 0);

        // Sliding window rolling hash update
        for (int i = length; i < s.length(); i++) {
            hash = ((hash - (s.charAt(i - length) - 'a') * pow % mod + mod) % mod * base + (s.charAt(i) - 'a')) % mod;

            if (map.containsKey(hash)) {
                int start = map.get(hash);
                String candidate = s.substring(start, start + length);
                if (s.substring(i - length + 1, i + 1).equals(candidate)) {
                    return candidate;
                }
            }
            map.put(hash, i - length + 1);
        }
        return "";
    }
}
