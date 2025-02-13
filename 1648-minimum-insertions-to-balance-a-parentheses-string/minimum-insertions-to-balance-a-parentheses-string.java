class Solution {
    public int minInsertions(String s) {
        
        Stack<Character> stack = new Stack<>();
        int result = 0;
        int index = 0;
        int n = s.length();

        while (index<n) {
            char c = s.charAt(index);
            if(c=='(') stack.add(c);
            else{
                if(index + 1<n && s.charAt(index+1)==')') {
                    index++;
                }else{
                    result++;
                }
                if(!stack.isEmpty()) stack.pop();
                else{
                    result++;
                }
            }
            index++;
        }
        result += stack.size()*2;
        return result;
    }
}