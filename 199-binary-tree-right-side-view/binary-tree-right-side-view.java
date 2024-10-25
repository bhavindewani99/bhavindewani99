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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        recursion(root, 0, res);
        return res;
    }

    private void recursion(TreeNode root, int level, List<Integer> res){
        if(root!=null){
            if(level>= res.size()){
                res.add(root.val);
            }else{
                res.set(level,root.val);
            }
            recursion(root.left, level+1, res);
            recursion(root.right, level+1, res);
        }
    }
}