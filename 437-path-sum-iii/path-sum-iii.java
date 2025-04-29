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
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        
        int fromRoot = countPaths(root, targetSum, 0);
        
        int fromLeft = pathSum(root.left, targetSum);
        int fromRight = pathSum(root.right, targetSum);
        
        return fromRoot + fromLeft + fromRight;
    }

    private int countPaths(TreeNode node, int targetSum, long currSum) {
        if (node == null) return 0;

        currSum += node.val;
        int count = currSum == targetSum ? 1 : 0;

        count += countPaths(node.left, targetSum, currSum);
        count += countPaths(node.right, targetSum, currSum);

        return count;
    }
}
