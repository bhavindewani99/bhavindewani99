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
    public int rob(TreeNode root) {
        
        int[] result = recursion(root);
        return Math.max(result[0], result[1]);
    }

    private int[] recursion(TreeNode root){
        if(root==null) return new int[]{0,0}; // With Root, Without Root

        int[] left = recursion(root.left);
        int[] right = recursion(root.right);

        int withRoot = root.val + left[1] + right[1];
        int withOutRoot = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[]{withRoot, withOutRoot};

    }
}