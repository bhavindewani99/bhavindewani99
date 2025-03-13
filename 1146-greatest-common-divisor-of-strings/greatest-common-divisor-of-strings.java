class Solution {
    public String gcdOfStrings(String str1, String str2) {

        int x = str1.length(), y=str2.length();
        int gcdVal = gcd(x, y);
        StringBuilder gcdString = new StringBuilder(str1.subSequence(0, gcdVal));
        StringBuilder temp1 = new StringBuilder(gcdString);
        StringBuilder temp2 = new StringBuilder(gcdString);

        while(temp1.length()<str1.length()) temp1.append(gcdString);
        while(temp2.length()<str2.length()) temp2.append(gcdString);

        return str1.equals(temp1.toString()) && str2.equals(temp2.toString()) ? gcdString.toString() : "";
    }

    private int gcd(int a, int b){
        if(a==0) return b;
        return gcd(b%a, a);
    }
}