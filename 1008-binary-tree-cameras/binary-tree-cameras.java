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
    int camerasRequired = 0;

    public int minCameraCover(TreeNode root) {
        if(recursion(root)==-1) camerasRequired++;

        return camerasRequired;
    }

    private int recursion(TreeNode root){
        if(root == null) return 1;

        int leftChild = recursion(root.left);
        int rightChild = recursion(root.right);

        if(leftChild==-1 || rightChild==-1){
            camerasRequired++;
            return 0;
        }

        if(leftChild==0 || rightChild==0) return 1;

        return -1;
    }
}

// 1 means I am covered I dont need camera
// -1 means I need camera
// 0 means I have installed camera