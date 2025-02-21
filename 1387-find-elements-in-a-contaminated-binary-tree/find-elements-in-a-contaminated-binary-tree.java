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
class FindElements {

    Set<Integer> set;
    public FindElements(TreeNode root) {
        set = new HashSet<>();
        buildTree(root, 0, set);
    }
    
    public boolean find(int target) {
        return set.contains(target);
    }

    private void buildTree(TreeNode root, int val, Set<Integer> set){
        if(root==null) return;
        root.val = val;
        set.add(val);
        buildTree(root.left, 2*val + 1, set);
        buildTree(root.right, 2*val + 2, set);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */