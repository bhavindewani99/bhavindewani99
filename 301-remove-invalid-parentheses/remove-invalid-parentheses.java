class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        int[] maxLen = {0};
        backTracking(s, 0, new StringBuilder(), 0, 0, set,maxLen);
        for(String curr : set) res.add(curr);
        return res;
    }

    private void backTracking(String s, int index, StringBuilder curr, int open , int close,  Set<String> set,int[] maxLen){
        if(index==s.length()){
            if(open==close){
                if(curr.length()>maxLen[0]){
                    maxLen[0] = curr.length();
                    set.clear();
                }
                if(curr.length()==maxLen[0]){
                    set.add(curr.toString());
                }
            }
            return;
        }
        if(s.charAt(index)=='('){
            curr.append("(");
            backTracking(s, index+1, curr, open+1, close, set,maxLen);
            curr.deleteCharAt(curr.length()-1);

            backTracking(s, index+1, curr, open, close, set,maxLen);
        }else if(s.charAt(index)==')'){

            backTracking(s, index+1, curr, open, close, set,maxLen);
            if(open>close){
                curr.append(")");
                backTracking(s, index+1, curr, open, close+1, set,maxLen);
                curr.deleteCharAt(curr.length()-1);
            }    
        }else{
            curr.append(s.charAt(index));
            backTracking(s, index+1, curr, open, close, set,maxLen);
            curr.deleteCharAt(curr.length()-1);
        }

    }
}