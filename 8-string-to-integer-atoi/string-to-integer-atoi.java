class Solution {
    public int myAtoi(String s) {

        int start = 0;
        int n = s.length();
        boolean isNeg = false;
        int ans = 0;

        while(start<n && s.charAt(start)==' ') start++;
        if(start<n && s.charAt(start)=='+') start++;
        else if(start<n && s.charAt(start)=='-'){
            isNeg=true;
            start++;
        } 
        while(start<n && Character.isDigit(s.charAt(start))){
            int val = s.charAt(start)-'0';
            if(ans>Integer.MAX_VALUE/10 || (ans==Integer.MAX_VALUE/10 && val>Integer.MAX_VALUE%10)){
                return isNeg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ans = ans*10 + val;
            start++;
        }
        return isNeg ? -ans : ans;

    }
}