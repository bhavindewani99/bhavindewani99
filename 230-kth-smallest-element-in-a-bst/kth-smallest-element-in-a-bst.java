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
    public int kthSmallest(TreeNode root, int k) {
        
        while (root!=null) {
            if(root.left == null){
                k--;
                if(k==0) return root.val;
                root = root.right;
            }else{
                TreeNode leftChild = root.left;
                while(leftChild.right!=null && leftChild.right != root){
                    leftChild = leftChild.right;
                }
                if(leftChild.right == null){
                    leftChild.right = root;
                    root = root.left;
                }else{
                    k--;
                    leftChild.right = null;
                    if(k==0) return root.val;
                    root = root.right;
                }
            }
        }
        return -1;
    }
}