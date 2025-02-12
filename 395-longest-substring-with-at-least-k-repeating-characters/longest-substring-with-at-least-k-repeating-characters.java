class Solution {
    public int longestSubstring(String s, int k) {
        return divideAndConquer(s, 0, s.length(), k);
    }
    
    private int divideAndConquer(String s, int start, int end, int k) {
        if (end - start < k) return 0;
        
        int[] freq = new int[26];
        for (int i = start; i < end; i++) {
            freq[s.charAt(i) - 'a']++;
        }
        
        for (int mid = start; mid < end; mid++) {
            if (freq[s.charAt(mid) - 'a'] > 0 && freq[s.charAt(mid) - 'a'] < k) {
                return Math.max(divideAndConquer(s, start, mid, k), divideAndConquer(s, mid + 1, end, k));
            }
        }
        
        return end - start;
    }
}
