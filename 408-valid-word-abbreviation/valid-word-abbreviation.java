class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int n = word.length();
        int m = abbr.length();
        int i=0, j=0;

        while(i<n && j<m){
            if(Character.isDigit(abbr.charAt(j))){
                StringBuilder temp = new StringBuilder();
                while(j<m && Character.isDigit(abbr.charAt(j))){
                    temp.append(abbr.charAt(j));
                    j++;
                }
                if(temp.charAt(0)=='0') return false;
                int increment = Integer.valueOf(temp.toString());
                if(i+increment>n) return false;
                i+=increment;
            }else{
                if(word.charAt(i)!=abbr.charAt(j)) return false;
                i++;
                j++;
            }
        }
        return i==n && j==m;
    }
}