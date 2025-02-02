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
    public TreeNode lcaDeepestLeaves(TreeNode root) {

        Map<TreeNode, Integer> map = new HashMap<>();
        findHeight(root, map);

        while(root!=null){
            int leftHeight = root.left==null ? -1 : map.get(root.left);
            int rightHeight = root.right==null ? -1 : map.get(root.right);
            if(leftHeight == rightHeight) return root;
            if(leftHeight > rightHeight) root = root.left;
            else root=root.right;
        }
        return null;
    }

    public int findHeight(TreeNode root, Map<TreeNode, Integer> map){
        if(root==null) return 0;
        int left = findHeight(root.left, map);
        int right = findHeight(root.right, map);
        map.put(root, 1 + Math.max(left, right));
        return 1 + Math.max(left, right);
    }
}