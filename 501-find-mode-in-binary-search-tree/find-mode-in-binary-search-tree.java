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
    int prev = 0;
    int maxFreq = 0;
    int currFreq =0;
    public int[] findMode(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inOrder(root, result);
        int[] ans = new int[result.size()];
        for(int i=0;i<result.size();i++) ans[i]= result.get(i);
        return ans;
    }

    private void inOrder(TreeNode root, List<Integer> result){
        if(root!=null){
            inOrder(root.left, result);

            if(root.val==prev){
                currFreq++;
            }else{
                prev = root.val;
                currFreq=1;
            }

            if(currFreq>maxFreq){
                result.clear();
                result.add(root.val);
                maxFreq = currFreq;
            }else if(currFreq == maxFreq){
                result.add(root.val);
            }

            inOrder(root.right, result);
        }
    }
}