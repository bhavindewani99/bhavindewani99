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
    int maxHeight = -1;
    TreeNode resultNode = null;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        height(root, 0);
        return resultNode;
    }

    private int height(TreeNode node, int currHeight) {
        if (node == null) return currHeight;
        
        int leftHeight = height(node.left, currHeight + 1);
        int rightHeight = height(node.right, currHeight + 1);

        if (leftHeight == rightHeight && leftHeight >= maxHeight) { 
            maxHeight = leftHeight;
            resultNode = node;
        }

        return Math.max(leftHeight, rightHeight);
    }
}
