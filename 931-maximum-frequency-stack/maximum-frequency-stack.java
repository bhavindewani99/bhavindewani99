class FreqStack {

    int freq = 0;
    Map<Integer, Integer> count; // value & count
    Map<Integer, Stack<Integer>> map; // count & stack of values

    public FreqStack() {
        count = new HashMap<>();
        map = new HashMap<>();
    }
    
    public void push(int val) {
        count.put(val, count.getOrDefault(val, 0) + 1);
        int c = count.get(val);
        freq = Math.max(freq, c);

        // FIX: create stack for c (not only when c == freq)
        if (!map.containsKey(c)) map.put(c, new Stack<>());

        map.get(c).push(val);
    }
    
    public int pop() {
        int ele = map.get(freq).pop();
        count.put(ele, count.get(ele) - 1);

        if(map.get(freq).isEmpty()) {
            map.remove(freq);
            freq--;
        }
        return ele;
    }
}
