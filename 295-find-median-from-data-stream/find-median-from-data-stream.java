class MedianFinder {

    int n1 =0, n2 =0;
    PriorityQueue<Double> p1, p2;
    public MedianFinder() {
        p1 = new PriorityQueue<>(Collections.reverseOrder());
        p2 = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        p1.add((double)num);
        if(Math.abs(p1.size()-p2.size())>1){
            p2.offer(p1.poll());
        }
        if(p2.size()>0 && p1.peek()>p2.peek()){
            double x = p1.poll();
            p1.add(p2.poll());
            p2.add(x);
        }
    }
    
    public double findMedian() {
        if(p2.size()==0) return p1.peek();
        if((p1.size()+p2.size())%2==0) return (p1.peek()+p2.peek())/2;
        return p1.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */