class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] map = new int[26];
        int n = s.length();

        for(char c : s.toCharArray()){
            map[c-'a']++;
        }

        if(s.length()%2==0){
            for(int i=0;i<26;i++){
                if(map[i]%2!=0) return false;
            }
            return true;
        }
        boolean odd = false;
        for(int i=0;i<26;i++){
            if(map[i]%2!=0){
                if(odd) return false;
                odd = true;
            }
        }
        return odd;
    }
}