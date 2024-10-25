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
        inOrder(root);
        head.left = tail;
        tail.right = head;
        return head;
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
}