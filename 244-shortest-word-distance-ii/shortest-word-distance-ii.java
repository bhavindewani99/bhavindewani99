class WordDistance {

    Map<String, List<Integer>> map;
    public WordDistance(String[] wordsDict) {
        map = new HashMap<>();
        for(int i=0;i<wordsDict.length;i++){
            if(map.containsKey(wordsDict[i])==false) map.put(wordsDict[i], new ArrayList<>());
            map.get(wordsDict[i]).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int i = 0, j = 0, min = Integer.MAX_VALUE;
        
        while(i < list1.size() && j < list2.size()){
            int pos1 = list1.get(i), pos2 = list2.get(j);
            min = Math.min(min, Math.abs(pos1 - pos2));
            if(pos1 < pos2) i++;
            else j++;
        }
        return min;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */