class Solution {
    public String betterCompression(String compressed) {
        int[] freq = new int[26];

        for(int i=0;i<compressed.length();i++){
            char c = compressed.charAt(i);
            int val = 0;
            i++;
            while(i<compressed.length() && Character.isDigit(compressed.charAt(i))){
                val = val*10 + (compressed.charAt(i)-'0');
                i++;
            }
            freq[c-'a']+=val;
            i--;
        }
        StringBuilder res = new StringBuilder();
        for(int i=0;i<26;i++){
            if(freq[i]>0){
                res.append((char)(i+'a'));
                res.append(freq[i]);
            }
            
        }
        return res.toString();
    }
}