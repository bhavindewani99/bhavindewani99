class Solution {
    public String removeOccurrences(String s, String part) {
        
        StringBuilder result = new StringBuilder();

        for(char c : s.toCharArray()){
            result.append(c);
            
            if(result.length() >= part.length()){
                String curr = result.substring(result.length()-part.length()).toString();
                if(curr.equals(part)){
                    result.setLength(result.length()-part.length());
                }
            }
        }
        return result.toString();
    }
}