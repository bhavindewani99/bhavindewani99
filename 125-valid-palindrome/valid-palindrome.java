class Solution {
    public boolean isPalindrome(String s) {
        int i=0;
        int j = s.length()-1;
        while(i<j){
            char x = s.charAt(i);
            char y = s.charAt(j);
            if(!Character.isLetterOrDigit(x)) i++;
            else if(!Character.isLetterOrDigit(y)) j--;
            else{
                if(Character.toLowerCase(x)!=Character.toLowerCase(y)) return false;
                i++;
                j--;
            }
        }
        return true;
    }
}