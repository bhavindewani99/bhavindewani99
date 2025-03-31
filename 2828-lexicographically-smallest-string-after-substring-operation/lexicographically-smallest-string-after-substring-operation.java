class Solution {
    public String smallestString(String s) {
        int n = s.length();
        StringBuilder result = new StringBuilder(s);

        int i = 0;
        while (i < n && s.charAt(i) == 'a') i++;

        if (i == n) {
            result.setCharAt(n - 1, 'z');
            return result.toString();
        }

        while (i < n && s.charAt(i) != 'a') {
            result.setCharAt(i, (char)(s.charAt(i) - 1));
            i++;
        }

        return result.toString();
    }
}
