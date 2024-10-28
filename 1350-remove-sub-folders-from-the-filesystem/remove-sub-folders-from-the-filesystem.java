class Solution {
    public List<String> removeSubfolders(String[] folder) {
        return removeFolders(folder);
        // Arrays.sort(folder);
        // Set<String> set = new HashSet<>();
        // List<String> res = new ArrayList<>();
        // int n = folder.length;

        // for(int i=0;i<n;i++){
        //     String path = folder[i];
        //     if(path.length()<=1 || path.charAt(0)!='/') continue;
        //     StringBuilder curr = new StringBuilder();
        //     curr.append("/");
        //     boolean contains = false;
        //     for(int j=1;j<path.length();j++){
        //         while(j<path.length() && path.charAt(j)!='/'){
        //             curr.append(path.charAt(j++));
        //         }
        //         if(set.contains(curr.toString())) {
        //             contains = true;
        //             break;
        //         }
        //         if(j<path.length()) curr.append("/");
        //     }
        //     if(contains==false){
        //         set.add(curr.toString());
        //     }
        // }
        // for(String curr : set) res.add(curr);
        // return res;
    }

    private List<String> removeFolders(String[] folders){
        Trie trie = new Trie();
        List<String> res = new ArrayList<>();
        for(String folder : folders){
            trie.addWord(folder);
        }

        for(String folder : folders){
            if(trie.checkPrefix(folder)==false){
                res.add(folder);
            }
        }

        return res;
    }
}


class Trie{
    Node root;
    Trie(){
        root = new Node();
    }

    public void addWord(String word){
        Node curr = root;
        String[] arr = word.split("/");
        for(String c : arr){
            if(curr.containsNode(c)==false){
                curr.putNode(c, new Node());
            }
            curr = curr.getNode(c);
        }
        curr.end = true;
    }

    public boolean checkPrefix(String word){
        Node curr = root;
        String[] arr = word.split("/");
        for(int i=0;i<arr.length-1;i++){
            curr = curr.getNode(arr[i]);
            if(curr.end==true) return true; 
        }
        return false;
    }
}

class Node{
    Map<String,Node> links;
    boolean end = false;
    Node(){
        links = new HashMap<>();
    }

    public boolean containsNode(String c){
        return links.containsKey(c);
    }

    public void putNode(String c, Node node){
        links.put(c, node);
    }

    public Node getNode(String c){
        return links.get(c);
    }
}
