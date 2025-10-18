class Solution {
    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        
        Trie trie = new Trie();

        // Step1 build trie
        buildTrie(trie, paths);

        // Step2 serialize and mark duplictaes
        Map<String, Node> seen = new HashMap<>();
        serializeAndMarkDups(trie.root, seen);

        // Step 3 travserse trie to build answer
        List<List<String>> result = new ArrayList<>();
        traverseTrie(trie.root, new ArrayList<>(), result);

        return result;
        
    }

    private void traverseTrie(Node root, List<String> current, List<List<String>> result){

        for(String path : root.links.keySet()){

            Node child = root.links.get(path);
            if(child.isDuplicate) continue;

            current.add(path);
            result.add(new ArrayList<>(current));
            traverseTrie(child, current, result);
            current.removeLast();
        }
    }

    private String serializeAndMarkDups(Node root, Map<String, Node> seen){
        if(root.links.size() == 0) return "";

        List<String> keys = new ArrayList<>(root.links.keySet());
        Collections.sort(keys);
        StringBuilder sb = new StringBuilder();

        for(String key : keys){
            sb.append("(");
            sb.append(key);
            sb.append(serializeAndMarkDups(root.links.get(key), seen));
            sb.append(")");
        }

        String serializeKey = sb.toString();
        if(seen.containsKey(serializeKey)){
            root.isDuplicate = true;
            seen.get(serializeKey).isDuplicate = true;
        }else{
            seen.put(serializeKey, root);
        }
        return serializeKey;
    }



    private void buildTrie(Trie trie, List<List<String>> paths){
        for(List<String> path : paths) trie.addPath(path);
    }

    class Node{
        Map<String, Node> links = new HashMap<>();
        boolean isDuplicate = false;
    }

    class Trie{
        Node root;
        Trie(){
            root = new Node();
        }

        private void addPath(List<String> path){
            Node node = root;
            for(String word : path){
                if(!node.links.containsKey(word)) node.links.put(word, new Node());
                node = node.links.get(word);
            }
        }
    }
}