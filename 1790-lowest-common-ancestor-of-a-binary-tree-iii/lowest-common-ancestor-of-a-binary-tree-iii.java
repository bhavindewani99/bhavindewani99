/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Node dummHeadP = p;
        Node dummHeadQ =q;
        if(p==q) return p;
        while (p!=q) {
            p = p.parent == null ? dummHeadQ : p.parent;
            q = q.parent == null ? dummHeadP : q.parent;
        }
        
        return p;
    }
}