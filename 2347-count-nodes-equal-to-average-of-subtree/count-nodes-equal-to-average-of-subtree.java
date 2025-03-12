

import static java.lang.Math.rint;

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
    public int averageOfSubtree(TreeNode root) {
        return recursion(root).satisfiedNodes;
    }

    private Pair recursion(TreeNode root){
        if(root == null) return new Pair(0, 0, 0); 

        Pair left = recursion(root.left);
        Pair right = recursion(root.right);

        int currSum = root.val + left.sum + right.sum;
        int currNodes = left.nodes + right.nodes + 1;
        int average = currSum / currNodes; 

        int satisfiedCount = left.satisfiedNodes + right.satisfiedNodes + (average == root.val ? 1 : 0);
        
        return new Pair(currSum, currNodes, satisfiedCount);
    }

    class Pair {
        int sum, nodes, satisfiedNodes;
        Pair(int sum, int nodes, int satisfiedNodes) {
            this.sum = sum;
            this.nodes = nodes;
            this.satisfiedNodes = satisfiedNodes;
        }
    }
}
