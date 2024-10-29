class Solution {
    public int calculate(String s) {
        int result = 0;
        int number =0;
        Stack<Integer> stack = new Stack<>();
        int sign = 1;

        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                number = number*10 + (int) (c-'0');
            }else if(c=='+'){
                result = result + sign * number;
                number = 0;
                sign = 1;
            }else if(c=='-'){
                result = result + sign * number;
                sign = -1;
                number = 0;
            }else if(c=='('){
                stack.add(result);
                stack.add(sign);
                sign=1;
                result = 0;
            }else if(c==')'){
                result = result + sign * number;
                number = 0;
                result = result * stack.pop();
                result = result + stack.pop();
            }
        }
        if(number !=0) result += sign * number;
        return result;
    }
}