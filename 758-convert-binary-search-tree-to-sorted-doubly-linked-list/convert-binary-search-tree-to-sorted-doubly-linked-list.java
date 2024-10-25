/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    Node head, tail;
    public Node treeToDoublyList(Node root) {
        if(root==null) return root;
        List<Node> inorder = new ArrayList<>();
        listInorder(root, inorder);

        for(int i=0;i<inorder.size();i++){
            Node node = inorder.get(i);
            node.right = i==inorder.size()-1 ? inorder.get(0) : inorder.get(i+1);
            node.left = i==0 ? inorder.get(inorder.size()-1) : inorder.get(i-1);
        }

        return inorder.get(0);
        // if(root==null) return root;
        // inOrder(root);
        // head.left = tail;
        // tail.right = head;
        // return head;
    }

    private void inOrder(Node node){
        if(node!=null){
            inOrder(node.left);

            if(head==null){
                head=node;
            }
            if(tail!=null){
                node.left = tail;
                tail.right = node;
            }

            tail = node;
            inOrder(node.right);
        }
    }

    private void listInorder(Node root, List<Node> inorder){
        if(root!=null){
            listInorder(root.left, inorder);
            inorder.add(root);
            listInorder(root.right,inorder);
        }
    }
}