class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {

        int[] word2Freq = new int[26];
        List<String> result = new ArrayList<>();

        // get the count of characters of word2 then get get the count of characters for each word in words1
        // count of characters in words1 should be greater then count of word2 to be universal

        for(String word : words2){
            int[] curr = new int[26];
            for(char c : word.toCharArray()){
                curr[c-'a']++;
                word2Freq[c-'a'] = Math.max(word2Freq[c-'a'], curr[c-'a']);
            }
        }

        for(String word : words1){
            int curr[] = new int[26];

            for(char c : word.toCharArray()) curr[c-'a']++;

            // check it can universal or not
            boolean flag = true;
            for(int i=0;i<26;i++){
                if(curr[i] < word2Freq[i]){
                    flag = false;
                    break;
                }
            }
            
            if(flag) result.add(word);
        }
        return result;
    }

}