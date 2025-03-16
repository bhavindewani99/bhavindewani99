

import com.sun.source.tree.Tree;

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
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return iterativeSolution(root);
        // return check(root.left,root.right);
    }

    private boolean check(TreeNode p,TreeNode q){
        if(p==null && q==null) return true;
        if(p==null || q== null) return false;
        return p.val==q.val && check(p.left,q.right) && check(p.right,q.left);
    }

    private boolean iterativeSolution(TreeNode root) {
        if (root == null) return true; // An empty tree is symmetric

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            if (left == null && right == null) continue;
            if (left == null || right == null || left.val != right.val) return false;

            // Enqueue children in symmetric order
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }

}