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
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> sortedArray = new ArrayList<>();
        convertIntoArray(root, sortedArray);

        for(int element : queries){
            int min_element = findElement(sortedArray, element, true);
            int max_element = findElement(sortedArray, element, false);
            List<Integer> temp = Arrays.asList(min_element, max_element);
            result.add(temp);
        }

        return result;
    }

    private int findElement(List<Integer> sortedArray, int target, boolean findMinimum) {
        int result = -1;
        int low = 0, high = sortedArray.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midVal = sortedArray.get(mid);

            if (midVal == target) {
                return target;
            } else if (midVal < target) {
                if (findMinimum) {
                    result = midVal;  // candidate for floor (<= target)
                }
                low = mid + 1;
            } else { // midVal > target
                if (!findMinimum) {
                    result = midVal;  // candidate for ceil (>= target)
                }
                high = mid - 1;
            }
        }

        return result;
    }


    private void convertIntoArray(TreeNode root, List<Integer> sortedArray ){
        if(root==null) return;
        convertIntoArray(root.left, sortedArray);
        sortedArray.add(root.val);
        convertIntoArray(root.right, sortedArray);
    }
}