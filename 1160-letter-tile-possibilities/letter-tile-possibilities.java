class Solution {
    public int numTilePossibilities(String tiles) {
        
        Map<Character, Integer> map = new HashMap<>();

        for(char c : tiles.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        
        return backTrack(map);
    }

    private int backTrack(Map<Character, Integer> map){
        int result = 0;

        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            if(entry.getValue() > 0){
                result ++;
                map.put(entry.getKey(), entry.getValue() - 1);
                result += backTrack(map);
                map.put(entry.getKey(), entry.getValue() + 1);
            }
        }
        return result;
    }
}