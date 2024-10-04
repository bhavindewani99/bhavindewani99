class Node{
    Node[] links = new Node[26];
    int cntPre=0, endsWith=0;

    boolean containKey(char c){
        return links[c-'a']!= null;
    }

    void put(char c,Node node){
        links[c-'a'] = node;
    }

    Node getNode(char c){
        return links[c-'a'];
    }


}

class Trie {
    Node root;
    public Trie() {
        root= new Node();
    }
    
    public void insert(String word) {
        Node node = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(node.containKey(c)==false){
                node.put(c, new Node());
            }
            node=node.getNode(c);
            node.cntPre++;
        }
        node.endsWith++;
    }
    
    public int countWordsEqualTo(String word) {
        Node node = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(node.containKey(c)==false) return 0;
            node=node.getNode(c);
        }
        return node.endsWith;
    }
    
    public int countWordsStartingWith(String word) {
        Node node = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(node.containKey(c)==false) return 0;
            node=node.getNode(c);
        }
        return node.cntPre;
    }
    
    public void erase(String word) {
        Node node = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(node.containKey(c)==false) return;
            node=node.getNode(c);
            if(node.cntPre>0) node.cntPre--;
        }
        if(node.endsWith>0) node.endsWith--;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * int param_2 = obj.countWordsEqualTo(word);
 * int param_3 = obj.countWordsStartingWith(prefix);
 * obj.erase(word);
 */