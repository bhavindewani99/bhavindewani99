class Solution {
    private final String[] ones = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", 
                                   "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", 
                                   "Seventeen", "Eighteen", "Nineteen"};
    private final String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] thousands = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        int i = 0;
        StringBuilder result = new StringBuilder();

        while (num > 0) {
            if (num % 1000 != 0) {
                result.insert(0, helper(num % 1000) + (thousands[i].isEmpty() ? "" : " " + thousands[i]) + " ");
            }
            num /= 1000;
            i++;
        }

        return result.toString().trim();
    }

    private String helper(int num) {
        if (num < 20) {
            return ones[num];
        } else if (num < 100) {
            return tens[num / 10] + (num % 10 != 0 ? " " + ones[num % 10] : "");
        } else {
            return ones[num / 100] + " Hundred" + (num % 100 != 0 ? " " + helper(num % 100) : "");
        }
    }
}
