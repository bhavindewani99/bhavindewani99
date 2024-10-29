class RandomizedSet {
    Map<Integer, Integer> map;
    List<Integer> list;
    Random rand;
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if(!map.containsKey(val)){
            int size = list.size();
            list.add(val);
            map.put(val, size);
            return true;
        }
        return false;
    }
    
    public boolean remove(int val) {
        if(map.containsKey(val)==false) return false;
        int index = map.get(val);
        list.set(index, list.get(list.size() - 1));
        map.put(list.get(index), index);
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        int random = rand.nextInt(list.size());
        return list.get(random);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */