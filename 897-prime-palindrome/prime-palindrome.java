class Solution {
    public int primePalindrome(int n) {

        if (n <= 2) return 2;
        if (n <= 3) return 3;
        if (n <= 5) return 5;
        if (n <= 7) return 7;
        if (n <= 11) return 11;
        
        int length = String.valueOf(n).length();
        if (length % 2 == 0) {
            n = (int) Math.pow(10, length);
        }
        
        while (true) {
            if (isPalindrome(n) && isPrime(n)) {
                return n;
            }
            n++;
            if (String.valueOf(n).length() % 2 == 0) {
                n = (int) Math.pow(10, String.valueOf(n).length()) + 1;
            }
        }
    }

    private boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    private boolean isPalindrome(int n) {
        String s = String.valueOf(n);
        int left = 0;
        int right = s.length() - 1;
        
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}