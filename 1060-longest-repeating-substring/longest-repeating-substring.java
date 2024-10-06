class Node{
    Node[] links = new Node[26];
    int ends =0;

    public boolean containsKey(char c) { return links[c-'a']!=null; }

    public void put(char c, Node node) { links[c-'a'] = node; }

    public Node getNode(char c) { return links[c-'a']; }
}

class Trie{

    Node root;

    Trie() {
        root = new Node();
    }

    public int insert(String word){
        Node node = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(node.containsKey(c)==false){
                node.put(c, new Node());
            }
            node = node.getNode(c);
        }
        node.ends++;
        return node.ends;
    }

}


class Solution {
    public int longestRepeatingSubstring(String s) {

        Trie trie = new Trie();
        
        int res = 0;
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                int curr = trie.insert(s.substring(i,j+1));
                if(curr>1 && j-i+1 > res){
                    res = j-i+1;
                } 
            }
        }
        return res;
    }
}