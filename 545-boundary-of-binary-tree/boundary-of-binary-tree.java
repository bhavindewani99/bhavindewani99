class Solution {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        if (!isLeaf(root)) result.add(root.val);
        leftboundry(root.left, result);        
        addLeafNode(root, result);         
        List<Integer> temp = new ArrayList<>();
        rightboundry(root.right, temp);    
        Collections.reverse(temp);           
        result.addAll(temp);                
        return result;
    }

    private void leftboundry(TreeNode root, List<Integer> result) {
        if (root == null || isLeaf(root)) return;
        result.add(root.val);
        if (root.left != null) leftboundry(root.left, result);
        else leftboundry(root.right, result);
    }

    private void addLeafNode(TreeNode root, List<Integer> result) {
        if (root != null) {
            if (isLeaf(root)) result.add(root.val);
            addLeafNode(root.left, result);
            addLeafNode(root.right, result);
        }
    }

    private void rightboundry(TreeNode root, List<Integer> result) {
        if (root == null || isLeaf(root)) return;
        result.add(root.val);
        if (root.right != null) rightboundry(root.right, result);
        else rightboundry(root.left, result);
    }

    private boolean isLeaf(TreeNode node) {
        return (node.left == null && node.right == null);
    }
}
