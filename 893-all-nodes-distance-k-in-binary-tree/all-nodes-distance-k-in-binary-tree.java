/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        Map<TreeNode,TreeNode> parent = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        findParents(root,parent);
        int currLevel=0;
        queue.offer(target);
        visited.add(target);

        while(!queue.isEmpty()){
            int n = queue.size();
            if(currLevel==k) break;
            for(int i=0;i<n;i++){
                TreeNode node = queue.poll();
                if(node.left!=null && visited.add(node.left)) queue.offer(node.left);
                if(node.right!=null && visited.add(node.right)) queue.offer(node.right);
                if(parent.containsKey(node) && visited.add(parent.get(node))) queue.offer(parent.get(node));
            }
            currLevel++;
        }

        while(!queue.isEmpty()) res.add(queue.poll().val);

        return res;



    }

    private void findParents(TreeNode root, Map<TreeNode,TreeNode> parent){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int n = queue.size();
            for(int i=0;i<n;i++){
                TreeNode node = queue.poll();
                if(node.left!=null){
                    parent.put(node.left,node);
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    parent.put(node.right,node);
                    queue.offer(node.right);
                }
            }
        }
    }
}