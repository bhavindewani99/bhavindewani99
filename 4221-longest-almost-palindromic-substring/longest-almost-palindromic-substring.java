class Solution {
    public int almostPalindromic(String s) {
        int n = s.length();
        int maxLen = 0;
        for(int i = 0;i<n;i++){
            // check for the odd String
            int oddString = expand(i,i,s);
            // check for the even String
            int evenString = expand(i,i+1,s);
            maxLen = Math.max(maxLen,Math.max(oddString,evenString));
        }
        return maxLen;
    }
    public static int expand(int i,int j,String s){
        int n = s.length();
        // normal palindrome check
        while(i>=0 && j<n && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }
        int maxLen = j-i-1;
        // if the full string is palindrome  then return immediately 
        if(maxLen == n)return n;

        //skip one step left
        int l = i-1;
        int r = j;
        while(l>=0 && r<n && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        maxLen = Math.max(maxLen,r-l-1);

        // skip one step right
        l = i;
        r = j+1;
        while(l>=0 && r<n && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        maxLen = Math.max(maxLen,r-l-1);
        return maxLen;
    }
}