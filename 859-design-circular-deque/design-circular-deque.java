class MyCircularDeque {

    Node head, tail;
    int k, size;

    public MyCircularDeque(int k) {
        head = new Node(-1);
        tail = new Node(-1);
        this.k = k;
        size = 0;
        head.next = tail;
        head.prev = tail;
        tail.prev = head;
        tail.next = head;
        
    }
    
    public boolean insertFront(int value) {
        if(isFull()) return false;
        Node nextNode = head.next;
        Node newNode = new Node(value);
        newNode.next = nextNode;
        nextNode.prev = newNode;
        newNode.prev = head;
        head.next = newNode;
        size++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(isFull()) return false;
        Node prevNode = tail.prev;
        Node newNode = new Node(value);
        newNode.prev = prevNode;
        newNode.next = tail;
        tail.prev = newNode;
        prevNode.next = newNode;
        size++;
        return true;
    }
    
    public boolean deleteFront() {
        if(isEmpty()) return false;

        Node deleteNode = head.next;
        Node nextNode = deleteNode.next;

        nextNode.prev=head;
        head.next = nextNode;
        size--;
        return true;
    }
    
    public boolean deleteLast() {
        if(isEmpty()) return false;
        Node preNode = tail.prev.prev;
        preNode.next = tail;
        tail.prev = preNode;
        size--;
        return true;
    }
    
    public int getFront() {
        if(isEmpty()) return -1;
        return head.next.val;
    }
    
    public int getRear() {
        if(isEmpty()) return -1;
        return tail.prev.val;
    }
    
    public boolean isEmpty() {
        return size==0;
    }
    
    public boolean isFull() {
        return size==k;
    }

    class Node{
        int val;
        Node next, prev;
        Node(int val){
            this.val = val; 
        }
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */