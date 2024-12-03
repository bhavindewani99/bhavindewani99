class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder result = new StringBuilder();
        int index =0;
        for(int i=0;i<s.length();i++){
            if(index<spaces.length && i==spaces[index]){
                result.append(" ");
                result.append(s.charAt(i));
                index++;
            }else{
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }
}