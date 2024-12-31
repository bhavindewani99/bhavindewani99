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
    public int getMinimumDifference(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        travesal(root, values);
        int diff = Integer.MAX_VALUE;

        for(int i=1;i<values.size();i++){
            diff=Math.min(diff, Math.abs(values.get(i-1)-values.get(i)));
        }

        return diff;
    }

    private void travesal(TreeNode root, List<Integer> values){
        if(root!=null){
            travesal(root.left, values);
            values.add(root.val);
            travesal(root.right, values);
        }
    }
}