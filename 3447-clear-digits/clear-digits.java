class Solution {
    public String clearDigits(String s) {
        
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                if(!stack.isEmpty() && !Character.isDigit(stack.peek())) stack.pop();
                else stack.add(c);
            }else stack.add(c);
        }

        StringBuilder result = new StringBuilder();
        while(stack.isEmpty()==false) result.append(stack.pop());

        return result.reverse().toString();
    }
}