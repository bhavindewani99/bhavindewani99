class Node{
    Node prev, next;
    int freq;
    Set<String> keys;
    Node(int f){
        freq = f;
        keys = new HashSet<>();
        prev =null;
        next = null;
    }
}

class AllOne {
    Map<String, Node> map;
    Node head, tail;
    
    public AllOne() {
        map = new HashMap<>();
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
    }
    
    public void inc(String key) {
        Node currHead = head;
        int newFreq = 1;
        if(map.containsKey(key)){
            currHead = map.get(key);
            newFreq = currHead.freq + 1;
            currHead.keys.remove(key);
        }
        if(currHead.next.freq==newFreq){
            currHead.next.keys.add(key);
        }else{
            Node newNode = new Node(newFreq);
            Node nextNode = currHead.next;
            nextNode.prev = newNode;
            newNode.next = nextNode;
            currHead.next = newNode;
            newNode.prev = currHead;
            newNode.keys.add(key);
        }
        map.put(key, currHead.next);
        if(currHead.keys.size()==0 && currHead!=head){
            removeNode(currHead);
        }
    }
    
    public void dec(String key) {
        Node currHead = map.get(key);
        int newFreq = currHead.freq-1;
        currHead.keys.remove(key);
        if(newFreq==0){
            if(currHead.keys.size()==0){
                removeNode(currHead);
            }
            map.remove(key);
            return;
        }
        if(currHead.prev.freq==newFreq){
            currHead.prev.keys.add(key);
        }else{
            Node newNode = new Node(newFreq);
            Node preNode = currHead.prev;
            newNode.keys.add(key);
            newNode.prev = preNode;
            preNode.next = newNode;
            currHead.prev = newNode;
            newNode.next = currHead;
            newNode.keys.add(key);
        }
        map.put(key, currHead.prev);
        if(currHead.keys.size()==0 && currHead!=head){
            removeNode(currHead);
        }
    }
    
    public String getMaxKey() {
        if(tail.prev==head) return "";
        return tail.prev.keys.iterator().next();
    }
    
    public String getMinKey() {
        if(head.next==tail) return "";
        return head.next.keys.iterator().next();
    }

    private void removeNode(Node node){
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */