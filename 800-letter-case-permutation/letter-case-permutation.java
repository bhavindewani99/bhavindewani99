class Solution {
    public List<String> letterCasePermutation(String s) {
        
        List<String> res = new ArrayList<>();
        backtrack(s, new StringBuilder(), res, 0);
        return res;
    }

    private void backtrack(String s, StringBuilder curr, List<String> res, int index){
        if(index == s.length()){
            res.add(curr.toString());
            return;
        }

        if(Character.isDigit(s.charAt(index))){
            curr.append(s.charAt(index));
            backtrack(s, curr, res, index+1);
            curr.deleteCharAt(curr.length()-1);
        }else{
            curr.append(Character.toUpperCase(s.charAt(index)));
            backtrack(s, curr, res, index+1);
            curr.deleteCharAt(curr.length()-1);

            curr.append(Character.toLowerCase(s.charAt(index)));
            backtrack(s, curr, res, index+1);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}