class Solution {
    public List<Integer> partitionLabels(String s) {
        
        Map<Character, Integer> indexMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int left = 0;
        int maxWeCanGo = -1;

        for(int i=0;i<s.length();i++){
            indexMap.put(s.charAt(i), i);
        }

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(i>maxWeCanGo) maxWeCanGo = indexMap.get(c);
            if(i==maxWeCanGo){
                result.add(i-left+1);
                left = i+1;
            }else{
                maxWeCanGo = Math.max(maxWeCanGo, indexMap.get(c));
            }
        }

        return result;

    }
}