class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if(strs.length==0) return res;
        Map<String, List<String>> map = new HashMap<>();

        for(String curr : strs){
            int[] hash = new int[26];
            for(char c : curr.toCharArray()){
                hash[c-'a']++;
            }
            StringBuilder key = new StringBuilder();
            for(int i=0;i<26;i++){
                key.append("#");
                key.append(hash[i]);
            }
            String newKey = key.toString();
            if(map.containsKey(newKey)==false) map.put(newKey, new ArrayList<>());
            map.get(newKey).add(curr);
        }

        for(List<String> curr : map.values()){
            res.add(curr);
        }
        return res;
    }
}