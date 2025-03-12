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
    public List<TreeNode> generateTrees(int n) {
        return recursion(1, n);
    }

    private List<TreeNode> recursion(int left, int right){

        List<TreeNode> result = new ArrayList<>();

        if(left>right) {
            result.add(null);
            return result;
        }

        
        for(int rootNode = left;rootNode<=right;rootNode++){
            for(TreeNode leftTree : recursion(left, rootNode-1)){
                for(TreeNode rightTree : recursion(rootNode+1, right)){
                    TreeNode root = new TreeNode(rootNode, leftTree, rightTree);
                    result.add(root);
                }
            }
        }
        return result;
    }
}