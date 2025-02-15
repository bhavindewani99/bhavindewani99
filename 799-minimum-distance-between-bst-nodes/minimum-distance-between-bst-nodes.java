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
    TreeNode prev = null;
    int mini = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        inOrder(root);
        return mini;
    }

    private void inOrder(TreeNode root){
        if(root==null) return;
        inOrder(root.left);
        if(prev!=null) mini = Math.min(mini, root.val - prev.val);
        prev = root;
        inOrder(root.right);

    }
}