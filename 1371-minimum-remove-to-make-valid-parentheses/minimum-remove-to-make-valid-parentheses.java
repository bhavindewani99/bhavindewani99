class Solution {
    public String minRemoveToMakeValid(String s) {
        
        StringBuilder result = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c==')'){
                if(stack.size()>0) {
                    stack.pop();
                    result.append(c);
                }
            }else{
                if(c=='(') stack.add(result.length());
                result.append(c);
            }
        }

        while(stack.size()>0){
            result.deleteCharAt(stack.pop());
        }

        return result.toString();
    }
}