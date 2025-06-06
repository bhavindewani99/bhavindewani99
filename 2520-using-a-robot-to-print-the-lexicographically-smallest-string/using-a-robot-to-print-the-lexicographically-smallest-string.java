class Solution {
    public String robotWithString(String s) {
        
        int[] frequency = new int[26];

        for(char c : s.toCharArray()) frequency[c-'a']++;
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){

            stack.add(c);
            frequency[c-'a']--;
            
            while(!stack.isEmpty() && smallestExist(frequency, stack.peek()) == false){
                result.append(stack.pop());
            }                
            
            
        }
        
        return result.toString();
    }

    private boolean smallestExist(int[] frequency, char c){
        int length = (c-'a');
        //System.out.println("Length is "+ length);

        for(int i=0;i<length;i++){
            if(frequency[i] > 0) return true;
        }

        return false;
    }
}