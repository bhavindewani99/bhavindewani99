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
    TreeNode result;
    int maxHeight = 0;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        findNode(root, 0);
        return result;
    }

    private int findNode(TreeNode root, int height){
        if(root == null) return height;

        int leftHeight = findNode(root.left, height+1);
        int rightHeight = findNode(root.right, height+1);

        if(leftHeight==rightHeight && leftHeight >= maxHeight){
            maxHeight = leftHeight;
            result = root;
        }
        return Math.max(leftHeight, rightHeight);
    }
}