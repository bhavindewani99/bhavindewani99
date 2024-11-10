class TimeMap {
    Map<String,List<Pair>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)) map.put(key, new ArrayList<>());
        map.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        List<Pair> temp = map.get(key);
        int index = binary(temp, timestamp);
        if(index==-1) return "";
        return temp.get(index).value;
    }

    private int binary(List<Pair> temp, int timestamp){
        int low = 0;
        int high = temp.size()-1;
        int ans = -1;
        while(low<=high){
            int mid = (low+high)/2;
            if(temp.get(mid).time<=timestamp){
                ans = mid;
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return ans;
    }

    class Pair{
        int time;
        String value;
        Pair(int time, String value){
            this.time = time;
            this.value = value;
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */