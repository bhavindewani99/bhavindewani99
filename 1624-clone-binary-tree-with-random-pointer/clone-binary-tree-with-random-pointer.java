/**
 * Definition for Node.
 * public class Node {
 *     int val;
 *     Node left;
 *     Node right;
 *     Node random;
 *     Node() {}
 *     Node(int val) { this.val = val; }
 *     Node(int val, Node left, Node right, Node random) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *         this.random = random;
 *     }
 * }
 */

class Solution {
    public NodeCopy copyRandomBinaryTree(Node root) {

        if(root == null) return null;
        Map<Node, NodeCopy> map = new HashMap<>();
        preTravesal(root, map);

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if(node.left != null) {
                map.get(node).left = map.get(node.left);
                queue.offer(node.left);
            }
            if(node.right != null) {
                map.get(node).right = map.get(node.right);
                queue.offer(node.right);
            }
            if(node.random != null){
                map.get(node).random = map.get(node.random);
            }
        }

        return map.get(root);
    }

    private void preTravesal(Node root, Map<Node, NodeCopy> map){
        if(root==null) return;

        NodeCopy node = new NodeCopy(root.val);
        map.put(root, node);
        preTravesal(root.left, map);
        preTravesal(root.right, map);
    }
}