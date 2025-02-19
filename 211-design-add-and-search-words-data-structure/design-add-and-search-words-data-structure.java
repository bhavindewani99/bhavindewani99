class WordDictionary {
    Trie trie;
    Node root;
    public WordDictionary() {
        trie = new Trie();
        root = trie.root;
    }
    
    public void addWord(String word) {
        trie.addWord(word);
    }
    
    public boolean search(String word) {
        return trie.containsWord(word, root, 0);
    }
}

class Trie{
    Node root;
    Trie(){
        root = new Node();
    }

    public void addWord(String word){
        Node node = root;
        for(char c : word.toCharArray()){
            if(node.containsNode(c)==false){
                node.addNode(c, new Node());
            }
            node = node.getNode(c);
        }
        node.end = true;
    }

    public boolean containsWord(String word, Node node, int index){
        if(node==null) return false;
        if(index==word.length()) return node.end;
        boolean result = false;
        if(word.charAt(index)=='.'){
            for(int i=0;i<26;i++){
                result = result || containsWord(word, node.getNode((char)(i+'a')), index+1);
            }
        }else{
            result = containsWord(word, node.getNode(word.charAt(index)), index+1);
        }
        return result;
    }
}

class Node{
    Node[] links;
    boolean end ;
    Node(){
        links = new Node[26];
    }

    Node getNode(char c){
        return links[c-'a'];
    }

    boolean containsNode(char c){
        return links[c-'a']!=null;
    }

    void addNode(char c, Node node){
        links[c-'a'] = node;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */