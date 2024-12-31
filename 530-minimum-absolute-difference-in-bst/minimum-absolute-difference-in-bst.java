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
    int ans = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return ans;
    }

    private void inOrder(TreeNode node){
        if(node!=null){
            inOrder(node.left);
            if(prev!=null){
                ans = Math.min(ans, Math.abs(prev.val - node.val));
            }
            prev=node;
            inOrder(node.right);
        }
    }
}