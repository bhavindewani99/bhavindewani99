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
    public int maxPathSum(TreeNode root) {
        int res[] = {root.val};
        recursion(root, res);
        return res[0];
    }

    private int recursion(TreeNode root,int[] res){
        if(root==null) return 0;
        int left = Math.max(0, recursion(root.left,res));
        int right = Math.max(0, recursion(root.right, res));
        res[0] = Math.max(res[0], root.val+left+right);
        return root.val + Math.max(left, right);
    }
}