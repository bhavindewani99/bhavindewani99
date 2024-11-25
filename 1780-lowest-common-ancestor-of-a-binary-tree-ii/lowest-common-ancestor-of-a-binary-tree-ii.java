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
        int[] exists = new int[2];
        TreeNode result = recursion(root, p, q,exists);
        return exists[0]+exists[1]==2 ? result : null; 
    }

    private TreeNode recursion(TreeNode root, TreeNode p, TreeNode q, int[] exists){
        if(root==null) return root;
        TreeNode left =  recursion(root.left,p,q,exists);
        TreeNode right = recursion(root.right,p,q,exists);
        if(root==p){
            exists[0]=1;
            return root;
        }
        if(root==q){
            exists[1]=1;
            return root;
        }
        if(left==null) return right;
        if(right==null) return left;
        return root;
    }
}