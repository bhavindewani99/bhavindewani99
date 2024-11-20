class MKAverage {
    int m,k;
    SortedList l1, l2, l3;
    Deque<Integer> queue;
    public MKAverage(int m, int k) {
        this.m = m;
        this.k = k;
        l1 = new SortedList();
        l2 = new SortedList();
        l3 = new SortedList();
        queue = new LinkedList<>();
    }
    
    public void addElement(int num) {
        queue.offerLast(num);
        if(l1.isEmpty() || l1.getLast()>= num) l1.add(num);
        else if(l2.isEmpty() || l2.getLast()>= num) l2.add(num);
        else l3.add(num);

        if(queue.size() > m){
            int removeElement = queue.pollFirst();
            if(l1.contains(removeElement)) l1.remove(removeElement);
            else if(l2.contains(removeElement)) l2.remove(removeElement);
            else l3.remove(removeElement);
        }

        if(l1.size>k){
            l2.add(l1.removeLast());
        }else if(l1.size < k && l2.isEmpty()==false){
            l1.add(l2.removeFirst());
        }

        if(l2.size > m-k-k){
            l3.add(l2.removeLast());
        }else if(l2.size < m-k-k && l3.isEmpty()==false){
            l2.add(l3.removeFirst());
        }
    }
    
    public int calculateMKAverage() {
        if(l1.size + l2.size + l3.size < m) return -1;
        return (int) Math.floor((double)(l2.sum) / (l2.size));
    }

    class SortedList{
        int sum;
        int size;
        TreeMap<Integer, Integer> map = new TreeMap<>();

        public void add(int n){
            map.put(n,map.getOrDefault(n,0) +1);
            sum+=n;
            size++;
        }

        public boolean contains(int n) { return map.containsKey(n); }

        public boolean isEmpty() { return map.size()==0; }

        public void remove(int n){
            if(map.containsKey(n)==false) return;
            sum-=n;
            size--;
            if(map.get(n)==1) map.remove(n);
            else map.put(n, map.get(n)-1);
        }

        public int removeLast(){
            Map.Entry<Integer, Integer> lastEntry = map.lastEntry();
            if(lastEntry.getValue()==1) map.remove(lastEntry.getKey());
            else map.put(lastEntry.getKey(), lastEntry.getValue()-1);
            sum -= lastEntry.getKey();
            size--;
            return lastEntry.getKey();
        }

        public int removeFirst(){
            Map.Entry<Integer, Integer> firstEntry = map.firstEntry();
            if(firstEntry.getValue()==1) map.remove(firstEntry.getKey());
            else map.put(firstEntry.getKey(), firstEntry.getValue()-1);
            sum -= firstEntry.getKey();
            size--;
            return firstEntry.getKey();
        }

        public int getLast() { return map.lastKey(); }

        public int getFirst() { return map.firstKey(); }

    }
}

/**
 * Your MKAverage object will be instantiated and called as such:
 * MKAverage obj = new MKAverage(m, k);
 * obj.addElement(num);
 * int param_2 = obj.calculateMKAverage();
 */