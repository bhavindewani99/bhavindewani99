class Solution {
    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode, TreeNode> parentHashMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        TreeNode starTreeNode = null;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.val == start) starTreeNode = node;
            if (node.left != null) {
                parentHashMap.put(node.left, node);
                queue.offer(node.left);
            }
            if (node.right != null) {
                parentHashMap.put(node.right, node);
                queue.offer(node.right);
            }
        }
        
        int time = -1;
        queue.offer(starTreeNode);
        Set<TreeNode> visited = new HashSet<>();
        visited.add(starTreeNode);

        while (!queue.isEmpty()) {
            time++;
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (node.left != null && !visited.contains(node.left)) {
                    queue.offer(node.left);
                    visited.add(node.left);
                }
                if (node.right != null && !visited.contains(node.right)) {
                    queue.offer(node.right);
                    visited.add(node.right);
                }
                if (parentHashMap.containsKey(node) && !visited.contains(parentHashMap.get(node))) {
                    queue.offer(parentHashMap.get(node));
                    visited.add(parentHashMap.get(node));
                }
            }
        }

        return time;
    }
}
