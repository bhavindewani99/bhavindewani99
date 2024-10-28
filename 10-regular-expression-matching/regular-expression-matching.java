class Solution {
    public boolean isMatch(String s, String p) {
        return recursion(s, 0, p, 0);
    }


    private boolean recursion(String s, int i, String p, int j){
        if(i==s.length() && j>=p.length()) return true;
        if(j>=p.length()) return false;

        boolean match = (i<s.length() && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.'));
        if(j+1 < p.length() && p.charAt(j+1)=='*'){
            return recursion(s, i, p, j+2) || (match && recursion(s, i+1, p, j));
        }
        if(match){
            return recursion(s, i+1, p, j+1);
        }

        return false;
    }
}