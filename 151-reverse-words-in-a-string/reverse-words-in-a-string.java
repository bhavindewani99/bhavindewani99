class Solution {
    public String reverseWords(String s) {
        
        int left = 0, right = s.length()-1;
        Deque<String> deque = new LinkedList<>();
        StringBuilder curr = new StringBuilder();

        while(left<=right && s.charAt(left)==' ') left++; // removing front space
        while(left<=right && s.charAt(right)== ' ') right--; //removing back space

        while(left<=right){
            char currChar = s.charAt(left);

            if(currChar == ' ' && curr.length() > 0){
                deque.offerFirst(curr.toString());
                curr.setLength(0);
            }else if(currChar != ' '){
                curr.append(currChar);
            }
            left++;
        }

        if(curr.length() > 0) deque.offerFirst(curr.toString());

        return String.join(" ", deque);
    }
}