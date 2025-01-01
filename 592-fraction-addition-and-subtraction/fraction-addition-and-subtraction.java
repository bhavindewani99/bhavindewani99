class Solution {
    public String fractionAddition(String expression) {
        int num = 0; // Numerator
        int den = 1; // Denominator
        int index = 0; // Current index in the expression
        int n = expression.length(); // Length of the expression

        while (index < n) {
            int currNum = 0, currDen = 0;
            boolean isNegative = false;

            // Handle sign
            if (expression.charAt(index) == '-') {
                isNegative = true;
                index++;
            } else if (expression.charAt(index) == '+') {
                index++;
            }

            // Parse numerator
            while (index < n && Character.isDigit(expression.charAt(index))) {
                currNum = currNum * 10 + (expression.charAt(index++) - '0');
            }
            if (isNegative) currNum *= -1;

            // Skip the '/'
            if (index < n && expression.charAt(index) == '/') {
                index++;
            }

            // Parse denominator
            while (index < n && Character.isDigit(expression.charAt(index))) {
                currDen = currDen * 10 + (expression.charAt(index++) - '0');
            }

            // Update numerator and denominator
            num = num * currDen + den * currNum;
            den *= currDen;
        }

        // Simplify the result
        int gcd = findGcd(Math.abs(num), Math.abs(den)); // Use absolute values for GCD
        num /= gcd;
        den /= gcd;

        return num + "/" + den;
    }

    private int findGcd(int a, int b) {
        if (b == 0) return a;
        return findGcd(b, a % b);
    }
}
