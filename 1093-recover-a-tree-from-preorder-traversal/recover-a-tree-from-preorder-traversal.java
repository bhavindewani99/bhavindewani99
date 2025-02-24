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
    public TreeNode recoverFromPreorder(String traversal) {
        Stack<TreeNode> stack = new Stack<>();
        int i=0, n = traversal.length();

        while (i<n) {
            int depth = 0;
            while (i<n && traversal.charAt(i)=='-') {
                depth++;
                i++;
            }

            int nodeValue = 0;
            while (i<n && Character.isDigit(traversal.charAt(i))) {
                nodeValue = nodeValue*10 + (traversal.charAt(i++)-'0');
            }

            TreeNode node = new TreeNode(nodeValue);

            while(!stack.isEmpty() && stack.size()>depth) stack.pop();

            if(!stack.isEmpty()){
                if(stack.peek().left!=null) stack.peek().right = node;
                else stack.peek().left = node;
            }

            stack.add(node);
        }
        while(stack.size()>1) stack.pop();
        return stack.peek();
    }
}