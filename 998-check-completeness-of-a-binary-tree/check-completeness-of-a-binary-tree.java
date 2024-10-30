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
    public boolean isCompleteTree(TreeNode root) {
        return DFS(root);
    }

    private boolean BFS(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node!=null){
                queue.offer(node.left);
                queue.offer(node.right);
            }else{
                while(!queue.isEmpty()){
                    if(queue.poll()!=null) return false;
                }
            }
        }
        return true;
    }

    private boolean DFS(TreeNode root){
        int totalNodes = countNodes(root);
        return DFSflow(root,1,totalNodes);
    }

    private boolean DFSflow(TreeNode root, int index, int totalNodes){
        if(root==null) return true;
        if(index>totalNodes) return false;
        return DFSflow(root.left,2*index, totalNodes) && DFSflow(root.right,2*index+1,totalNodes);
    }

    private int countNodes(TreeNode node){
        if(node==null) return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }
}