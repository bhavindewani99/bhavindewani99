class Solution {
    public char findTheDifference(String s, String t) {
        
        int[] map = new int[26];
        char result = '.';

        for(char c : s.toCharArray()) map[c-'a']++;
        for(char c : t.toCharArray()) map[c-'a']--;
        for(int i=0;i<26;i++){
            if(map[i]<0) result = (char) (i+'a');
        }
        return result;
        
    }
}