class Node{
    Node[] links = new Node[26];
    boolean flag = false;

    boolean containsKey(char c){
        return links[c-'a'] != null;
    }

    void put(char c, Node node){
        links[c-'a'] = node;
    }

    Node getNode(char c){
        return links[c-'a'];
    }

    void setFlag(){
        flag=true;
    }

    boolean getFlag(){
        return flag;
    }
}

class Trie {
    Node root;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node node = root;
        for(int i =0;i<word.length();i++){
            char c = word.charAt(i);
            if(node.containsKey(c)==false){
                node.put(c, new Node());
            }
            node=node.getNode(c);
        }
        node.setFlag();
    }
    
    public boolean search(String word) {
        Node node = root;
        for(int i =0;i<word.length();i++){
            char c = word.charAt(i);
            if(node.containsKey(c)==false) return false;
            node=node.getNode(c);
        }
        return node.getFlag();
    }
    
    public boolean startsWith(String prefix) {
         Node node = root;
        for(int i =0;i<prefix.length();i++){
            char c = prefix.charAt(i);
            if(node.containsKey(c)==false) return false;
            node=node.getNode(c);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */