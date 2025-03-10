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
    public int largestBSTSubtree(TreeNode root) {
        return recursion(root).maxLargest;
    }

    private Pair recursion(TreeNode root) {
        if (root == null) return new Pair(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, true);

        Pair leftPair = recursion(root.left);
        Pair rightPair = recursion(root.right);

        // If left or right subtree is not a BST, current subtree cannot be a BST
        if (!leftPair.isBST || !rightPair.isBST || root.val <= leftPair.maxVal || root.val >= rightPair.minVal) {
            return new Pair(0, 0, Math.max(leftPair.maxLargest, rightPair.maxLargest), false);
        }

        // Current subtree is a valid BST
        int currSize = leftPair.maxLargest + rightPair.maxLargest + 1;
        return new Pair(Math.min(root.val, leftPair.minVal), Math.max(root.val, rightPair.maxVal), currSize, true);
    }

    class Pair {
        int minVal, maxVal, maxLargest;
        boolean isBST;

        Pair(int minVal, int maxVal, int maxLargest, boolean isBST) {
            this.minVal = minVal;
            this.maxVal = maxVal;
            this.maxLargest = maxLargest;
            this.isBST = isBST;
        }
    }
}
