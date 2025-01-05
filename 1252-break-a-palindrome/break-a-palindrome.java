class Solution {
    public String breakPalindrome(String palindrome) {
        int n = palindrome.length();
        if (n == 1) return ""; // A single-character palindrome cannot be broken

        char[] chars = palindrome.toCharArray();

        // Iterate through the first half of the string
        for (int i = 0; i < n / 2; i++) {
            if (chars[i] != 'a') {
                // Replace the first non-'a' character with 'a' and return the result
                chars[i] = 'a';
                return new String(chars);
            }
        }

        // If all characters in the first half are 'a', change the last character
        chars[n - 1] = 'b';
        return new String(chars);
    }
}
