class Solution {
    public String removeDuplicates(String s) {
        StringBuilder res = new StringBuilder();
        for(char c: s.toCharArray()){
            if(!res.isEmpty() && res.charAt(res.length()-1)==c){
                res.deleteCharAt(res.length()-1);
            }else{
                res.append(c);
            }
        }
    
        return res.toString();
    }
}