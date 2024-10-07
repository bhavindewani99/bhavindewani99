class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c=='('){
                stack.push(c);
            }else{
                if(stack.size()==0 || stack.peek()==')'){
                    stack.push(c);
                }
                else{
                    stack.pop();
                }
            }
        }
        return stack.size();
    }
}