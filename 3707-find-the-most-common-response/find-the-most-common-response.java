class Solution {
    public String findCommonResponse(List<List<String>> responses) {
        Map<String, Integer> map = new HashMap<>();

        for(int i=0;i<responses.size();i++){
            Set<String> visited = new HashSet<>();
            for(String curString : responses.get(i)){
                if(visited.add(curString)){
                    map.put(curString, map.getOrDefault(curString, 0) + 1);
                }
            }
        }

        String result = "";
        int maxCount = 0;

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(entry.getValue() > maxCount){
                maxCount = entry.getValue();
                result = entry.getKey();
            }else if(entry.getValue() == maxCount && result.compareTo(entry.getKey()) > 0){
                result = entry.getKey();
            }
        }

        return result;
    }
}