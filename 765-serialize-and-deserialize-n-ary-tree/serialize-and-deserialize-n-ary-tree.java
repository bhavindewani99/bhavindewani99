/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Codec {
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if(root==null) return "";
        StringBuilder result = new StringBuilder();
        dfsSerialize(root, result);
        result.deleteCharAt(result.length()-1);
        return result.toString();
    }

    private void dfsSerialize(Node root, StringBuilder result){
        if(root!=null){
            result.append(root.val+"*"+root.children.size()+",");
            for(int i=0;i<root.children.size();i++){
                dfsSerialize(root.children.get(i), result);
            }
        }
    }
	
    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if(data.length()==0) return null;
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return generateTree(queue);
    }

    private Node generateTree(Queue<String> queue) {
        if (queue.isEmpty()) return null;

        String[] curr = queue.poll().split("\\*");
        Node root = new Node(Integer.valueOf(curr[0]), new ArrayList<>());
        int childrenCount = Integer.valueOf(curr[1]);

        for (int i = 0; i < childrenCount; i++) {
            root.children.add(generateTree(queue));
        }

        return root;
    }

}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));