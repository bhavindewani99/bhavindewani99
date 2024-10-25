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
    public int sumNumbers(TreeNode root) {
        int[] ans={0};
        recursion(root, "", ans);
        return ans[0];
    }

    private void recursion(TreeNode root, String curr, int[] ans){
        if(root!=null){
            curr += root.val;
            if(root.left==null && root.right==null) ans[0] += Integer.valueOf(curr);
            recursion(root.left, curr, ans);
            recursion(root.right, curr, ans);
        }
    }
}