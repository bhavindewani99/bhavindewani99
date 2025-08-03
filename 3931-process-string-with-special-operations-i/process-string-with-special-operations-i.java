class Solution {
    public String processStr(String s) {
        
        StringBuilder result = new StringBuilder();

        for(char c : s.toCharArray()){
            if(c == '*'){
                if(result.length()>0) result.setLength(result.length()-1);
            }else if(c == '#'){
                result.append(result);
            }else if(c== '%'){
                result.reverse();
            }else{
                result.append(c);
            }
        }

        return result.toString();
    }
}