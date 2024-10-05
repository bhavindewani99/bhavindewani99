

class Node{
    Node[] links = new Node[2];

    public boolean containsKey(int bit){
        return links[bit] != null;
    }

    public void put(int bit, Node node){
        links[bit] = node; 
    }

    public Node getNode(int bit){
        return links[bit];
    }
}

class Trie{
    Node root;
    Trie(){
        root = new Node();
    }

    public void insert(int number){
        Node node = root;
        for(int i=31;i>=0;i--){
            int currBit = (number>>i) & 1;
            if(node.containsKey(currBit)==false){
                node.put(currBit, new Node());
            }
            node = node.getNode(currBit);
        }
    }

    public int getMaximum(int number){
        Node node = root;
        int res = 0;
        for(int i=31;i>=0;i--){
            int currBit = (number>>i) & 1;
            int oppositeBit = 1 - currBit;
            if(node.containsKey(oppositeBit)){
                res = res | (1<<i);
                node = node.getNode(oppositeBit);
            }else{
                node = node.getNode(currBit);
            }
        }
        return res;
    }
}

class Solution {
    public int findMaximumXOR(int[] nums) {

        Trie trie = new Trie();
        int maxi = 0;
        
        for(int i : nums) trie.insert(i);
        for(int i : nums){
            maxi = Math.max(maxi, trie.getMaximum(i));
        }

        return maxi;
    }
}