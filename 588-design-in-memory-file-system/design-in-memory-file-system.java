class Node{
    Node(){}
    String name;
    Map<String, Node> links = new TreeMap<>();
    StringBuilder content = new StringBuilder();
    boolean isFile;

    Node(String name){
        this.name = name;
    }
}

class FileSystem {

    Node root;

    public FileSystem() {
        root = new Node();
    }
    
    public List<String> ls(String path) {
        Node node = traversePath(path);
        return node.isFile ? List.of(node.name) : List.copyOf(node.links.keySet());
    }
    
    public void mkdir(String path) {
        traversePath(path);
    }
    
    public void addContentToFile(String filePath, String content) {
        Node node = traversePath(filePath);
        node.content.append(content);
        node.isFile=true;
    }
    
    public String readContentFromFile(String filePath) {
        Node node = traversePath(filePath);
        return node.content.toString();
    }

    private Node traversePath(String path){
        Node node = root;
        String[] paths = path.split("/");
        for(int i=1;i<paths.length;i++){
            if(!node.links.containsKey(paths[i])){
                node.links.put(paths[i], new Node(paths[i]));
            }
            node = node.links.get(paths[i]);
        }
        return node;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */