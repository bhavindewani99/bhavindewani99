class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {

        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        Map<String,Boolean> map = new HashMap<>();
        for(String word : words) set.add(word);
        
        for(String word : words){
            if(recursion(word, set,map)){
                res.add(word);
            }
        }
        return res;

    }

    private boolean recursion(String word, Set<String> set, Map<String,Boolean> map){
        if(word.equals("")) return true;
        if(map.containsKey(word)) return map.get(word);

        for(int i=1;i<word.length();i++){
            String prefix = word.substring(0,i);
            String suffix = word.substring(i);
            if(set.contains(prefix) && (set.contains(suffix) || recursion(suffix, set,map))){
                map.put(word,true);
                return true;
            }
        }
        map.put(word,false);
        return false;
    }
}