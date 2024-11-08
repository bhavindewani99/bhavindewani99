class MyCircularQueue {

    int start;
    int end;
    int[] array;
    int size;
    int count;

    public MyCircularQueue(int k) {
        this.size = k;
        array = new int[k];
        start = -1;
        end = -1;
        count = 0;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) return false;

        if (isEmpty()) {
            start = 0;
        }
        end = (end + 1) % size;
        array[end] = value;
        count++;
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) return false;

        if (start == end) { 
            start = -1;
            end = -1;
        } else {
            start = (start + 1) % size;
        }
        count--;
        return true;
    }
    
    public int Front() {
        if (isEmpty()) return -1;
        return array[start];
    }
    
    public int Rear() {
        if (isEmpty()) return -1;
        return array[end];
    }
    
    public boolean isEmpty() {
        return count == 0;
    }
    
    public boolean isFull() {
        return count == size;
    }
}
