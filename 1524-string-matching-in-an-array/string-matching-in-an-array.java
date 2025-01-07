class Solution {
    public List<String> stringMatching(String[] words) {
        Set<String> result = new HashSet<>();
        int n = words.length;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j && words[j].contains(words[i])){
                    result.add(words[i]);
                }
            }
        }

        List<String> ans = new ArrayList<>();
        for(String s : result) ans.add(s);

        return ans;
    }
}