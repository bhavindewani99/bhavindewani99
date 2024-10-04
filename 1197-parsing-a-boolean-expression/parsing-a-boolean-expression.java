class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();
        boolean res;
        for(int i=0;i<expression.length();i++){
            char c = expression.charAt(i);
            if(c!=')'){
                stack.add(c);
                continue;
            }
            int noOfTrue = 0;
            int noOfFalse = 0;

            while(stack.peek()!='('){
                if(stack.peek()=='t') noOfTrue++;
                if(stack.peek()=='f') noOfFalse++;
                stack.pop();
            }
            stack.pop();
            if(stack.peek()=='&') {
                if(noOfFalse>0) res= false;
                else res = true;
            }
            else if(stack.peek()=='|'){
                if(noOfTrue>0) res = true;
                else res = false;
            }else{
                if(noOfFalse>0) res=true;
                else res = false;
            }
            if(res) stack.add('t');
            else stack.add('f');
        }
        
        return stack.peek()=='t';
    }
}