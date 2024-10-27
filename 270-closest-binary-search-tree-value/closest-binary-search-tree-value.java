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
        double[] diff = {Double.MAX_VALUE};
        int[] ans = {Integer.MAX_VALUE};
        recursion(root, target, diff, ans);
        return ans[0];
    }

    private void recursion(TreeNode root, double target, double[] diff, int[] ans){
        if(root!=null){
            if(Math.abs(target-root.val)== diff[0]){
                if(ans[0]>root.val)
                ans[0]=root.val;
            }else if(Math.abs(target-root.val)< diff[0]){
                ans[0]=root.val;
                diff[0] = Math.abs(target-root.val);
                if(diff[0]==0) return;
            }
            if(root.val>target){
                recursion(root.left, target, diff, ans);
            }else{
                recursion(root.right, target, diff, ans);
            }
            
        }
    }
}