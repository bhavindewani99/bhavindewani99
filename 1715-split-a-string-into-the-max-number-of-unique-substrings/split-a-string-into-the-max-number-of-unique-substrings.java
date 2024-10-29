class Solution {
    public int maxUniqueSplit(String s) {
        return recursion(0, s, new HashSet<>());
    }

    private int recursion(int index, String s,Set<String> set){
        if(index==s.length()){
            return 0;
        }
        int ans = 0;
        for(int i=index;i<s.length();i++){
            String newWord = s.substring(index,i+1);
            if(set.contains(newWord)==false){
                set.add(newWord);
                ans = Math.max(ans, 1 + recursion(i+1, s, set));
                set.remove(newWord);
            }
        }
        return ans;
    }
}