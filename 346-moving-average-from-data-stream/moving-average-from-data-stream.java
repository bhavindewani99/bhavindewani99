class MovingAverage {
    int size;
    Queue<Integer> queue;
    int n;
    double avg;
    public MovingAverage(int size) {
       this.size =size;
       queue = new LinkedList<>();
       n = 0;
       avg  =0; 
    }
    
    public double next(int val) {
        if(n==0){
            avg = val;
            n=1;
            queue.offer(val);
            return avg;
        }
        if(n<size){
            double sum = avg * n + val;
            n++;
            avg = sum/n;
            queue.offer(val);
            return avg;
        }
        double sum = avg*n - queue.poll() + val;
        avg = sum/n;
        queue.offer(val);
        return avg;
        

    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */