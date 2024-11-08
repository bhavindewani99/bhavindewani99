class MyHashMap {
    Node[] chain;
    public MyHashMap() {
        chain = new Node[10000];
        for(int i=0;i<10000;i++) chain[i] = new Node(-1,-1);
    }
    
    public void put(int key, int value) {
        int index = hash(key);
        Node head = chain[index];
        while(head.next!=null) {
            if(head.next.key == key){
                head.next.val = value;
                return;
            }
            head = head.next;
        }
        head.next = new Node(key,value);
    }
    
    public int get(int key) {
        int index = hash(key);
        Node head = chain[index].next;
        while(head!=null){
            if(head.key == key) return head.val;
            head = head.next;
        }
        return -1;
    }
    
    public void remove(int key) {
        int index = hash(key);
        Node head = chain[index];
        while(head!=null && head.next!=null){
            if(head.next.key == key){
                head.next = head.next.next;
                return;
            }
            head = head.next;
        }
    }

    public int hash(int key){
        return key%10000;
    }
}

class Node {
    int key;
    int val;
    Node next;
    Node(int key, int val){
        this.key = key;
        this.val = val;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */