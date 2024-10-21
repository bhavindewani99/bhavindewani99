class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        int res = 0;
        char operator = '+';

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);

            if(Character.isDigit(c)){
                num = num*10 + (c-'0');
            }

            if(check(c) || i==s.length()-1){
                if(operator=='+') stack.add(num);
                else if(operator=='-') stack.add(-num);
                else if(operator=='*') stack.add(stack.pop()*num);
                else if(operator=='/') stack.add(stack.pop()/num);
                num = 0;
                operator = c;
            }

        }

        while (stack.isEmpty()==false) {
            res += stack.pop();
        }

        return res;
    }

    private boolean check(char operator){
        return operator=='+' || operator=='-' || operator=='*' || operator=='/';
    }
}