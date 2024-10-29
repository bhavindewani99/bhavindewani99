class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for(String word : wordDict) set.add(word);
        List<String> result = new ArrayList<>();
        recursion(s, 0, set, new StringBuilder(), result);
        return result;

    }

    private void recursion(String s, int index, Set<String> set, StringBuilder curr, List<String> res){
        if(index==s.length()){
            res.add(curr.toString());
            return;
        }
        for(int i=index;i<s.length();i++){
            String newWord = s.substring(index,i+1);
            if(set.contains(newWord)){
                int len = curr.length();
                curr.append(newWord);
                if(i!=s.length()-1) curr.append(" ");
                recursion(s, i+1, set, curr, res);
                curr.setLength(len);
            }
        }
    }
}