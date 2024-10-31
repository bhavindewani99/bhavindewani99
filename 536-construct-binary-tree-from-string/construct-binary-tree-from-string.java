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
    public TreeNode str2tree(String s) {
        int n = s.length();
        if(n==0) return null;
        Stack<TreeNode> stack = new Stack<>();
        int i=0;

        while(i<n){
            char c = s.charAt(i);
            if(c=='-'){
                int num =0;
                i++;
                while(i<n && Character.isDigit(s.charAt(i))){
                    num = num * 10 + (s.charAt(i)-'0');
                    i++;
                }
                i--;
                TreeNode node = new TreeNode(-num);
                stack.add(node);
            }else if(Character.isDigit(c)){
                int num =0;
                while(i<n && Character.isDigit(s.charAt(i))){
                    num = num * 10 + (s.charAt(i)-'0');
                    i++;
                }
                i--;
                TreeNode node = new TreeNode(num);
                stack.add(node);
            }else if(c==')'){
                TreeNode node = stack.pop();
                if(stack.peek().left==null) stack.peek().left = node;
                else stack.peek().right = node;
            }
            i++;
        }
        return stack.peek();
    }
}