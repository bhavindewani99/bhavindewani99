class Solution {
    public String shortestPalindrome(String s) {
        
        String t = new StringBuilder(s).reverse().toString();
        int base = 29;
        long prefix = 0;
        long suffix = 0;
        int lastIndex=-1;
        long power =1;

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            int value = (c-'a') + 1;

            prefix = (prefix * base);
            prefix += value;

            suffix = suffix + value * power;
            power = power * base;

            if(suffix==prefix){
                lastIndex = i;
            }
        }
        String res = s.substring(lastIndex+1);
        String fi = new StringBuilder(res).reverse().toString();
        return fi + s;

    }
}