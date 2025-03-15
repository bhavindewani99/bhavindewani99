class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        
        int i=0, j=0;

        while(i<word.length() && j<abbr.length()){
            if(abbr.charAt(j)>'0' && abbr.charAt(j)<='9'){
                int num = 0;
                while(j<abbr.length() && Character.isDigit(abbr.charAt(j))){
                    num = num*10 + (abbr.charAt(j++)-'0');
                }
                i+=num;
                //if(i>word.length()) return false;
                //continue;
            }else{
                if(i<word.length() && j<abbr.length() && word.charAt(i)!=abbr.charAt(j)) return false;
                i++;
                j++;
            }
        }
        return i==word.length() && j==abbr.length();
    }
}