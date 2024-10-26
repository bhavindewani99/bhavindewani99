class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for(String curr : strings){
            if(curr.length()==1){
                if(!map.containsKey("-1")) map.put("-1", new ArrayList<>());
                map.get("-1").add(curr);
            }else{
                StringBuilder hash = new StringBuilder();
                for(int i=1;i<curr.length();i++){
                    int diff = (curr.charAt(i)-curr.charAt(i-1)+26)%26;
                    hash.append(diff);
                    hash.append(",");
                }
                if(!map.containsKey(hash.toString())) map.put(hash.toString(), new ArrayList<>());
                map.get(hash.toString()).add(curr);
            }
        }
        for(Map.Entry<String,List<String>> entry : map.entrySet()){
            res.add(entry.getValue());
        }
        return res;
    }
}