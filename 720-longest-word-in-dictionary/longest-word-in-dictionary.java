class Node{
    Node[] links = new Node[26];
    boolean flag = false;

    boolean continsKey(char c){
        return links[c-'a']!=null;
    }

    void put(char c, Node node){
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
            if(node.continsKey(c)==false){
                node.put(c, new Node());
            }
            node = node.getNode(c);
        }
        node.flag=true;
    }

    boolean search(String word){
        Node node = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(node.continsKey(c)==false){
                return false;
            }
            node = node.getNode(c);
        }
        return node.flag==true;
    }

    boolean searchPrefix(String word){
        Node node = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(node.continsKey(c)==false){
                return false;
            }
            node = node.getNode(c);
        }
        return true;
    }


}

class Solution {
    public String longestWord(String[] words) {

        Trie trie = new Trie();
        for(String curr : words){
            trie.insert(curr);
        }

        String res = "";
        Arrays.sort(words);

        for(String word : words){
            
            boolean exist = true;
            for(int i=1;i<=word.length()-1;i++){
                String curr = word.substring(0,i);
                if(trie.search(curr)==false){
                    exist=false;
                    break;
                }
            }
            if(exist && (word.length() > res.length() || (word.length() == res.length() && word.compareTo(res) < 0))){
                res = word;
            }
            
        }
        return res;
    }

}