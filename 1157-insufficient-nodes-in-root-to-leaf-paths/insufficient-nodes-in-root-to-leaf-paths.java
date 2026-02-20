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
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        boolean res = recursion(root, 0 , limit);
        if(!res) return null;

        return root;
    }

    private boolean recursion(TreeNode root, int sum, int limit){
        if(root.left == null && root.right == null){
            if(sum + root.val < limit) return false;
            return true;
        }

        sum += root.val;
        boolean left=false, right=false;

        if(root.left != null){
            left = recursion(root.left, sum, limit);
        }
        if(root.right != null) {
            right = recursion(root.right, sum, limit);
        }

        if(!left) root.left = null;
        if(!right) root.right = null;

        return left || right; 
    }
}