class Solution {
    public String breakPalindrome(String palindrome) {
        int n = palindrome.length();
        if(n==1) return "";
        int len = n/2;

        int index = len + 1;

        for(int i=0;i<len;i++){
            if(palindrome.charAt(i)!='a'){
                index = i;
                break;
            }
        }

        System.out.println("Index is "+index);

        StringBuilder sb = new StringBuilder(palindrome);

        if (index == len + 1) {
            
            sb.setCharAt(n-1, (char)(palindrome.charAt(n-1) + 1));
            return sb.toString();
        }

        sb.setCharAt(index, 'a');
        return sb.toString();

    }
}