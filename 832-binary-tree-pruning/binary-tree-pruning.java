/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode pruneTree(TreeNode root) {
        return recursion(root);
    }

    private TreeNode recursion(TreeNode root){
        if(root==null) return null;
        root.left = recursion(root.left);
        root.right = recursion(root.right);

        if(root.val!=1 && root.left==null && root.right==null) return null;
        return root;
    }
}