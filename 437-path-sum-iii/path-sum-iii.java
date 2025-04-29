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
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> map = new HashMap<>();
        map.put(0l, 1);

        return dfs(root, targetSum, 0, map);
    }


    private int dfs(TreeNode root, int targetSum, long currSum, Map<Long, Integer> map){
        if(root == null) return 0;

        int count = 0;
        currSum = currSum + root.val;
        long x = currSum - targetSum;
        
        if(map.getOrDefault(x, 0) > 0) count += map.get(x);
        map.put(currSum, map.getOrDefault(currSum, 0) + 1);

        count += dfs(root.left, targetSum, currSum, map);
        count += dfs(root.right, targetSum, currSum, map);

        map.put(currSum, map.getOrDefault(currSum, 0) - 1);

        return count;
    }
}