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
    public int[] maximizeXor(int[] nums, int[][] queries) {
        
        int n = queries.length;
        int[] res = new int[n];
        Arrays.fill(res,-1);
        Arrays.sort(nums);
        Trie trie = new Trie();
        ArrayList<ArrayList<Integer>> queArrayList = new ArrayList<>();

        for(int i=0;i<n;i++){
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(queries[i][0]);
            temp.add(queries[i][1]);
            temp.add(i);
            queArrayList.add(temp);
        }

        Collections.sort(queArrayList, new Comparator<>() {
            @Override
            public int compare(ArrayList<Integer> a,ArrayList<Integer> b){
                return a.get(1)-b.get(1);
            }
        });

        int index=0;
        for(int i=0;i<n;i++){
            int x = queArrayList.get(i).get(0);
            int a = queArrayList.get(i).get(1);
            int res_index = queArrayList.get(i).get(2);
            while(index<nums.length && nums[index]<=a){
                trie.insert(nums[index]);
                index++;
            }
            if(index>0){
                int maxXor = trie.getMaximum(x);
                res[res_index] = maxXor;
            }
        }

        return res;
    }
}