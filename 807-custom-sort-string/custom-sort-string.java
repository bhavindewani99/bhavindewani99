class Solution {
    public String customSortString(String order, String s) {
        
        int[] freq = new int[26];
        StringBuilder result = new StringBuilder();

        for(char c : s.toCharArray()) freq[c-'a']++;

        for(char c: order.toCharArray()){
            while(freq[c-'a']>0){
                result.append(c);
                freq[c-'a']--;
            } 
        }

        for(int i=0;i<26;i++){
            while(freq[i]>0){
                result.append((char) (i+'a'));
                freq[i]--;
            }
        }

        return result.toString();

    }
}