class MovingAverage {

    double sum, n;
    Queue<Double> queue;
    public MovingAverage(int size) {
        this.n = size;
        sum =0;
        queue = new LinkedList<>();
    }
    
    public double next(int val) {
        if(queue.size()==n){
            sum -= queue.poll();
        }
        sum += val;
        queue.offer(val*1.0);
        return sum/queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */