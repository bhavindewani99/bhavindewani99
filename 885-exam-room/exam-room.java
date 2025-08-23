class ExamRoom {

    TreeSet<Integer> set = new TreeSet<>();
    int n;
    public ExamRoom(int n) {
        this.n = n;
    }
    
    public int seat() {
        if(set.size() == 0){
            set.add(0);
            return 0;
        }
        int index = 0;
        int maxDistance = set.first();
        int prev = -1;

        for(int next : set){
            if(prev!=-1){
                int distance = (next-prev)/2;
                if(distance > maxDistance){
                    maxDistance = distance;
                    index = prev + (next-prev)/2;
                }
            }
            prev = next;
        }
        if(n-1-set.last() >maxDistance){
            index = n-1;
        }
        set.add(index);
        return index;
    }
    
    public void leave(int p) {
        set.remove(p);
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(n);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */