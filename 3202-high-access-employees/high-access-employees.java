class Solution {
    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        Map<String, List<Integer>> map= new HashMap<>();
        List<String> result = new ArrayList<>();

        for(List<String> access_time : access_times){
            map.putIfAbsent(access_time.get(0), new ArrayList<>());
            String time = access_time.get(1);
            int minutes = Integer.valueOf(time.substring(0,2)) * 60 + Integer.valueOf(time.substring(2));
            map.get(access_time.get(0)).add(minutes);
        }

        for(Map.Entry<String, List<Integer>> entry : map.entrySet()){
            Collections.sort(entry.getValue());
        }

        for(Map.Entry<String, List<Integer>> entry : map.entrySet()){
            List<Integer> list = entry.getValue();
            if(list.size()<3) continue;
            for(int i=0;i<list.size()-2;i++){
                if(list.get(i+2)-list.get(i)<60){
                    result.add(entry.getKey());
                    break;
                }
            }
        }

        return result;
        
    }
}