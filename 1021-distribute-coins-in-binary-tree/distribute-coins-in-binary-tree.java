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

    int result = 0;
    public int distributeCoins(TreeNode root) {
        recursion(root);

        return result;
    }

    private int[] recursion(TreeNode root){
        if(root == null) return new int[] {0, 0}; // [Size, Coins]

        int[] left_child = recursion(root.left);
        int[] right_child = recursion(root.right);

        int currSize = left_child[0] + right_child[0] + 1;
        int currCoins = root.val + left_child[1] + right_child[1];

        result += Math.abs(currSize - currCoins);

        return new int[] {currSize, currCoins};

    }
}