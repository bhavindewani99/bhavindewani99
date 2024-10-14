

import static java.util.Collections.max;

class Node{
    Map<Character,Node> map = new HashMap<>();
    boolean isEnd;
}

class Trie{
    Node root;
    Trie(){
        root = new Node();
    }

    void add(String word){
        Node node = root;
        for (char c : word.toCharArray()) {
            node.map.putIfAbsent(c, new Node());
            node = node.map.get(c);
        }
        node.isEnd = true;
    }

    int search(String word, int start){
        Node node = root;
        int end = -1;
        for(int i=start;i<word.length();i++){
            char c = word.charAt(i);
            if(node.map.containsKey(c)==false){
                return end;
            }
            node = node.map.get(c);
            if(node.isEnd==true){
                end=i;
            }
        }
        return end;
    }
}

class Solution {
    public String addBoldTag(String s, String[] words) {

        Trie trie = new Trie();
        int n = s.length();
        boolean[] bold = new boolean[n];
        StringBuilder res = new StringBuilder();
        int maxEnd=-1;
        boolean boldState = false;

        for(String word : words){
            trie.add(word);
        }

        for(int i=0;i<n;i++){
            maxEnd = Math.max(maxEnd, trie.search(s, i));
            bold[i] = maxEnd >=i;
        }

        for(int i=0;i<n;i++){
            if(bold[i]!=boldState){
                boldState = !boldState;
                res.append(boldState ? "<b>" : "</b>");
            }
            res.append(s.charAt(i));
        }
        if(boldState) res.append("</b>");

        return res.toString();




    }
}