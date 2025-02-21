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
    public int closestValue(TreeNode root, double target) {
        double[] arr= {Double.MAX_VALUE, -1}; // difference, result
        dfs(root, target, arr);
        return (int) (arr[1]);
    }

    private void dfs(TreeNode root, double target, double[] arr){
        if(root==null) return;
        double currDiff = Math.abs(target-root.val);
        if(currDiff < arr[0]){
            arr[0] = currDiff;
            arr[1] = root.val;
        }else if(currDiff == arr[0]){
            arr[1] = Math.min(arr[1], root.val);
        }
        if(root.val * 1.0 ==target){
            return;
        }else if(root.val > target) dfs(root.left, target, arr);
        else dfs(root.right, target, arr);
    }
}