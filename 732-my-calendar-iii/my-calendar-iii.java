class MyCalendarThree {

    TreeMap<Integer, Integer> map;
    public MyCalendarThree() {
        map = new TreeMap<>();
    }
    
    public int book(int startTime, int endTime) {
        map.put(startTime , map.getOrDefault(startTime, 0) + 1);
        map.put(endTime , map.getOrDefault(endTime, 0) - 1);

        int result = 0;
        int currSum = 0;
        
        for(int keys : map.keySet()){
            currSum += map.get(keys);
            result = Math.max(result, currSum);
        }

        return result;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(startTime,endTime);
 */