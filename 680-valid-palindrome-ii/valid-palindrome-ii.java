class Solution {
    public boolean validPalindrome(String s) {
        int n = s.length();
        int i=0;
        int j = n-1;

        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)){
                return check(i+1, j, s) || check(i, j-1, s);
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean check(int i,int j, String s){
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}