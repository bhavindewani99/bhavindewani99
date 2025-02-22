class Solution {
    public String removeKdigits(String num, int k) {
        if (k >= num.length()) return "0"; 
        StringBuilder stack = new StringBuilder(); 

        for (char digit : num.toCharArray()) {
            // While stack is not empty and the top of the stack is greater than the current digit
            // and we still have k digits to remove, pop the stack.
            while (k > 0 && stack.length() > 0 && stack.charAt(stack.length() - 1) > digit) {
                stack.setLength(stack.length() - 1);
                k--;
            }
            stack.append(digit); // Push current digit onto the stack.
        }

        // If there are still digits to remove, remove from the end of the result.
        while (k > 0) {
            stack.setLength(stack.length() - 1);
            k--;
        }

        // Remove leading zeros.
        int start = 0;
        while (start < stack.length() && stack.charAt(start) == '0') {
            start++;
        }
        
        // If all characters are zero or empty result
        if (start == stack.length()) return "0";
        
        // Return the remaining string.
        return stack.substring(start);
    }
}
