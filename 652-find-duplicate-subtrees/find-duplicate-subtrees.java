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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        recursion(root, list, map);
        return list;
    }

    private String recursion(TreeNode root, List<TreeNode> list, Map<String, Integer> map) {
        if (root == null) return "#";

        String left = recursion(root.left, list, map);
        String right = recursion(root.right, list, map);

        String serial = root.val + "," + left + "," + right;

        int freq = map.getOrDefault(serial, 0);
        if (freq == 1) {
            list.add(root);
        }
        map.put(serial, freq + 1);

        return serial;
    }
}