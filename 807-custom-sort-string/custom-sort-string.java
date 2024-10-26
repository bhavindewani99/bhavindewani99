class Solution {
    public String customSortString(String order, String s) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder res = new StringBuilder();

        for(char c : s.toCharArray()){
            if(!map.containsKey(c)) map.put(c, 0);
            map.put(c, map.get(c)+1);
        }

        for(char c : order.toCharArray()){
            if(map.containsKey(c)){
                for(int k=0;k<map.get(c);k++){
                    res.append(c);
                }
                map.remove(c);
            }
        }

        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            for(int k=0;k<entry.getValue();k++){
                res.append(entry.getKey());
            }
        }
        return res.toString();


    }
}