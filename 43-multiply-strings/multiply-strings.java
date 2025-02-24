class Solution {
    public String multiply(String num1, String num2) {
        
        if(num1.equals("0") || num2.equals("0")) return "0";

        StringBuilder n1 = new StringBuilder(num1);
        StringBuilder n2 = new StringBuilder(num2);
        n1.reverse();
        n2.reverse();
        int[] result = new int[n1.length()+n2.length()];

        for(int i=0;i<n1.length();i++){
            for(int j=0;j<n2.length();j++){
                int digit = (n1.charAt(i)-'0') * (n2.charAt(j)-'0');
                int index = i + j;
                result[index] += digit;
                result[index + 1] += result[index]/10;
                result[index] %= 10;
            }
        }
        StringBuilder resultString = new StringBuilder();
        for(int i:result) resultString.append(i);
        resultString.reverse();

        int index = 0;
        while(index<resultString.length() && resultString.charAt(index)=='0') index++;

        return resultString.substring(index).toString();

    }
}