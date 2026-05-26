import java.util.*;

class Solution {
    int result = 0;

    public int beautifulSubsets(int[] nums, int k) {
        // Sorting is required to only check (nums[index] - k) safely
        Arrays.sort(nums);
        
        // Use a standard global HashSet as requested
        recursion(0, nums, k, new HashSet<>());
        
        // Subtract 1 to exclude the empty subset configuration
        return result - 1;
    }

    private void recursion(int index, int nums[], int k, Set<Integer> set) {
        // Base case: decisions made for all elements
        if (index == nums.length) {
            result++;
            // System.out.println(set); // Uncomment to see subsets generated
            return;
        }

        // Choice 1: DO NOT TAKE the element at 'index'
        // We can always skip an element safely without conditions
        recursion(index + 1, nums, k, set);

        // Choice 2: TAKE the element at 'index'
        // Only allowed if it doesn't conflict with an existing smaller element
        if (!set.contains(nums[index] - k)) {
            
            // Check if this number is already tracked by an earlier identical element
            boolean alreadyExisted = set.contains(nums[index]);

            if (!alreadyExisted) {
                set.add(nums[index]); 
            }

            recursion(index + 1, nums, k, set);

            // Backtrack: ONLY remove it if WE were the ones who actually added it
            if (!alreadyExisted) {
                set.remove(nums[index]);
            }
        }
    }
}
