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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        inorder(root, targetSum, 0, res, new ArrayList<>());
        return res;
    }

    private void inorder(TreeNode root, int targetSum, int currSum,List<List<Integer>> res, List<Integer> temp){
        
        if(root==null) return;
        currSum += root.val;
        temp.add(root.val);

        if(root.left==null && root.right==null && currSum == targetSum){
            res.add(new ArrayList<>(temp));
        }else{
            inorder(root.left, targetSum, currSum, res, temp);
            inorder(root.right, targetSum, currSum, res,temp);
        }
        temp.removeLast();
    }
}