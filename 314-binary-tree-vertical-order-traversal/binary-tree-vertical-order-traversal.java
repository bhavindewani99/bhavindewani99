
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        
        Map<Integer, List<Integer>> columnTable = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        
        if (root != null) {
            queue.offer(new Pair(root, 0));
        }else{
            return result;
        }
        
        int minColumn = 0;
        int maxColumn = 0;

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            TreeNode node = pair.node;
            int column = pair.column;

            columnTable.putIfAbsent(column, new ArrayList<>());
            columnTable.get(column).add(node.val);
            
            minColumn = Math.min(minColumn, column);
            maxColumn = Math.max(maxColumn, column);

            if (node.left != null) {
                queue.offer(new Pair(node.left, column - 1));
            }
            if (node.right != null) {
                queue.offer(new Pair(node.right, column + 1));
            }
        }

        
        for (int i = minColumn; i <= maxColumn; i++) {
            result.add(columnTable.get(i));
        }

        return result;
    }

    // Pair class to hold the node and its corresponding column index
    static class Pair {
        TreeNode node;
        int column;

        Pair(TreeNode node, int column) {
            this.node = node;
            this.column = column;
        }
    }
}
