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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root,0));

        while(!queue.isEmpty()){

            int n = queue.size();
            int prev;
            boolean increasing = queue.peek().level%2==0;
            if(increasing) prev = Integer.MIN_VALUE;
            else prev = Integer.MAX_VALUE;
            for(int i=0;i<n;i++){
                Pair pair = queue.poll();
                TreeNode node = pair.node;
                int level = pair.level;
                if(increasing){
                    if(node.val%2==0 || node.val<=prev) return false;
                    prev = node.val;
                }else{
                    if(node.val%2!=0 || node.val>=prev) return false;
                    prev = node.val;
                }
                if(node.left!=null) queue.offer(new Pair(node.left, level+1));
                if(node.right!=null) queue.offer(new Pair(node.right, level+1));

            }
        }

        return true;
    }

    class Pair{
        TreeNode node;
        int level;
        Pair(TreeNode node, int level){
            this.node = node;
            this.level = level;
        }
    }

   
}