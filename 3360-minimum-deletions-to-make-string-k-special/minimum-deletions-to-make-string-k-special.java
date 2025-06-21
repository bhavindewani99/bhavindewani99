class Solution {
    public int minimumDeletions(String word, int k) {
        
        int[] freq = new int[26];
        int result = Integer.MAX_VALUE;

        for(char c : word.toCharArray()) freq[c-'a']++;

        for(int i=0;i<26;i++){
            int currMin = freq[i];
            int currMax = currMin + k;
            int currResult = findOperations(currMin, currMax, word, freq);
            result = Math.min(currResult, result);
        }
        return result;
    }

    private int findOperations(int currMin, int currMax, String word, int[] freq){
        int deletions = 0;

        for(int i=0;i<26;i++){
            if(freq[i] < currMin) deletions += freq[i];
            else if(freq[i] > currMax){
                deletions += (freq[i] - currMax);
            }
        }

        return deletions;
    }
}