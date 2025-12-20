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
    int resy = -1, res = -1;;
    public int findBottomLeftValue(TreeNode root) {
        recursion(root, 0);
        return res;
    }

    private void recursion(TreeNode root, int y){
        if(root == null) return;

        recursion(root.left, y+1);
        if(y > resy){
            res = root.val;
            resy = y;
        }
        recursion(root.right, y+1);
    }
}