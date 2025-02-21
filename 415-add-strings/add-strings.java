class Solution {
    public String addStrings(String num1, String num2) {

       StringBuilder result = new StringBuilder();
       int m = num1.length(), n = num2.length();
       int carry =0, i=m-1,j=n-1;

       while(i>=0 || j>=0 || carry>0){
            int x = i>=0 ? num1.charAt(i)-'0' : 0;
            int y = j>=0 ? num2.charAt(j)-'0' : 0;
            int currSum = x + y + carry;
            carry = currSum > 9 ? 1 : 0;
            result.append(currSum%10);
            i--;
            j--;
       } 
       return result.reverse().toString();
    }
}