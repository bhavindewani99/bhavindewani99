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
    public int[] treeQueries(TreeNode root, int[] queries) {
        int n = 100001;
        int[] level = new int[n];
        int[] height = new int[n];
        int[][] maxHeightLevel = new int[n][2];
        int[] result = new int[queries.length];
        
        fillArrays(level, height, maxHeightLevel, root, 0);

        for(int i=0;i<queries.length;i++){
            int node = queries[i];
            int currLevel = level[node];
            int currHeight = height[node];
            int maxHeight = maxHeightLevel[currLevel][0] == currHeight ? maxHeightLevel[currLevel][1] : maxHeightLevel[currLevel][0];

            result[i] = maxHeight + currLevel -1;
        }
        return result;

    }

    private int fillArrays(int[] level, int[] height, int[][] maxHeightLevel, TreeNode root, int currLevel){
        if(root==null) return 0;

        int currHeight = 1 + Math.max(fillArrays(level, height, maxHeightLevel, root.left, currLevel +1), fillArrays(level, height, maxHeightLevel, root.right, currLevel +1));
        int node = root.val;

        height[node] = currHeight;
        level[node] = currLevel;

        if(currHeight > maxHeightLevel[currLevel][0]){
            maxHeightLevel[currLevel][1] = maxHeightLevel[currLevel][0];
            maxHeightLevel[currLevel][0] = currHeight;
        } else if(currHeight > maxHeightLevel[currLevel][1])  maxHeightLevel[currLevel][1] = currHeight;

        return currHeight;


    }

}