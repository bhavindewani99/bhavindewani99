import java.util.*;

class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        return recursion(0, nums, k, new HashMap<>()) - 1; 
    } 
    
    private int recursion(int index, int nums[], int k, Map<Integer, Integer> set) { 
        if (index == nums.length) { 
            return 1; 
        } 
        
        // Don't take choice
        int not = recursion(index + 1, nums, k, set); 
        int take = 0; 
        
        // Take choice (only check nums[index] - k since the array is sorted)
        if (set.containsKey(nums[index] - k) == false) { 
            set.put(nums[index], set.getOrDefault(nums[index], 0) + 1); 
            
            take = recursion(index + 1, nums, k, set); 
            
            // Correctly subtract 1 from the count
            set.put(nums[index], set.get(nums[index]) - 1); 
            
            // Correctly remove the key using its name, not its value
            if (set.get(nums[index]) == 0) {
                set.remove(nums[index]); 
            }
        } 
        
        return take + not; 
    } 
}
