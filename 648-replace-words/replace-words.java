class Node{
    Node[] links = new Node[26];
    boolean end;

    boolean containsKey(char c){
        return links[c-'a']!=null;
    }

    void putNode(char c, Node node){
        links[c-'a'] = node;
    }

    Node getNode(char c){
        return links[c-'a'];
    }
}

class Trie{
    Node root;
    Trie(){
        root = new Node();
    }

    void insert(String word){
        Node node = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(node.containsKey(c)==false){
                node.putNode(c, new Node());
            }
            node = node.getNode(c);
        }
        node.end=true;
    }

    int check(String word){
        Node node = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(node.containsKey(c)==false){
                return -1;
            }
            node = node.getNode(c);
            if(node.end) return i;
        }
        return -1;
    }
}

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        
        Trie trie = new Trie();
        StringBuilder res = new StringBuilder();
        for(String curr : dictionary){
            trie.insert(curr);
        }

        String[] words = sentence.split(" ");
        for(String word : words){
            int index = trie.check(word);
            if(index==-1){
                res.append(word);
            }else{
                res.append(word.substring(0,index+1));
            }
            res.append(" ");
        }
        res.deleteCharAt(res.length()-1);
        return res.toString();
    }
}