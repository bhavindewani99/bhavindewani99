class LRUCache {
    Node head, tail;
    int capacity;
    Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        map = new HashMap<>();
        head.next=tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)==false) return -1;
        Node node = map.get(key);
        removeNode(node);
        addNode(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        
        if(map.containsKey(key)){
            Node node = map.get(key);
            removeNode(node);
            node.value=value;
            addNode(node);
            return;
        }
        Node node = new Node(key,value);
        if(map.size()<capacity){
            addNode(node);
            map.put(key, node);
            return;
        }
        Node lastNode = tail.prev;
        removeNode(lastNode);
        map.remove(lastNode.key);
        addNode(node);
        map.put(key, node);
        
    }

    private void removeNode(Node node){
        Node nextNode = node.next;
        Node prevnode = node.prev;
        nextNode.prev = prevnode;
        prevnode.next = nextNode;
    }

    private void addNode(Node node){
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }


    class Node{
        int key, value;
        Node prev, next;
        Node(int key, int value){
            this.key=key;
            this.value=value;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */