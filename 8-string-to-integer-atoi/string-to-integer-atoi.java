class Solution {
    public int myAtoi(String s) {
        
        
        int result = 0;
        int n = s.length(), index = 0;
        boolean isNegative = false;

        while (index<n && s.charAt(index)==' ') index++;
        if(index<n && s.charAt(index)=='-'){
            isNegative=true;
            index++;
        }
        else if(index<n && s.charAt(index)=='+') index++;

        while (index<n && Character.isDigit(s.charAt(index))) {

            int num = (s.charAt(index)- '0');

            if(result>Integer.MAX_VALUE/10 || (result==Integer.MAX_VALUE/10 && num>Integer.MAX_VALUE%10)){
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            result = result*10 + num;
            index++;
        }

        return isNegative ? -result : result;
    }
}