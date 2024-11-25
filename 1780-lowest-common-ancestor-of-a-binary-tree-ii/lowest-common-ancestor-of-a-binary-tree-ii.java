/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    boolean foundp, foundq;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        inOrder(root, p, q);
        if(foundp==false || foundq==false) return null;
        return recursion(root, p, q);
    }

    private TreeNode recursion(TreeNode root, TreeNode p, TreeNode q){
        if(root==null || root==p || root==q) return root;
        TreeNode left =  lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left==null) return right;
        else if(right==null) return left;
        else return root;
    }

    private void inOrder(TreeNode root, TreeNode p, TreeNode q){
        if(root!=null){
            if(root==p) foundp=true;
            if(root==q) foundq=true;
            inOrder(root.left, p, q);
            inOrder(root.right, p, q);
        }
    }
}