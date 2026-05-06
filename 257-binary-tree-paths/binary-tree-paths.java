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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        backtrack(root, new StringBuilder(), res);

        return res;
    }

    private void backtrack(TreeNode root, StringBuilder curr, List<String> res){
        int len = curr.length();

        curr.append(root.val);

        if(root.left == null && root.right == null){
            res.add(curr.toString());
        }else{
            curr.append("->");
            if(root.left!=null) {
                
                backtrack(root.left, curr, res);
            }
            if(root.right != null){
            
                backtrack(root.right, curr, res);
            }
        }

        curr.setLength(len);
    }
}