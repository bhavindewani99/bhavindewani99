class Solution {
    public boolean isAdditiveNumber(String num) {
        return recursion(0, -1, -1, 0, num);
    }

    private boolean recursion(int index, long firstNum, long secondNum, int count, String num) {
        if (index == num.length()) {
            return count >= 3; // must have at least 3 numbers in the sequence
        }

        long curr = 0;
        for (int i = index; i < num.length(); i++) {
            // Leading zero check
            if (i > index && num.charAt(index) == '0') break;

            curr = curr * 10 + (num.charAt(i) - '0');

            if (firstNum == -1) {
                if (recursion(i + 1, curr, secondNum, count + 1, num)) return true;
            } else if (secondNum == -1) {
                if (recursion(i + 1, firstNum, curr, count + 1, num)) return true;
            } else {
                long sum = firstNum + secondNum;
                if (curr == sum) {
                    if (recursion(i + 1, secondNum, curr, count + 1, num)) return true;
                } else if (curr > sum) {
                    break; // No need to proceed further if current number exceeds expected sum
                }
            }
        }

        return false;
    }
}
