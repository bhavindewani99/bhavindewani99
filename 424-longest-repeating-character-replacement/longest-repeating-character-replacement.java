class Solution {
    public int characterReplacement(String s, int k) {
        
        int n = s.length();
        int result = 0;
        int left = 0;
        int[] freq = new int[26];

        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            freq[c-'A']++;
            int maxi = getMax(freq);

            while((i-left+1)-maxi > k){
                freq[s.charAt(left++)-'A']--;
                maxi = getMax(freq);
            }

            result = Math.max(result, i-left+1);

        }

        return result;

    }

    private int getMax(int[] freq){
        int maxi =0;
        for(int i : freq) maxi = Math.max(maxi, i);
        return maxi;
    }
}