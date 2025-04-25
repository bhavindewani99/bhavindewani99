class Solution {
    public int countCompleteSubarrays(int[] nums) {
        
        Set<Integer> totalDistinct = new HashSet<>();
        HashMap<Integer, Integer> currDistinct = new HashMap<>();
        int left = 0, n = nums.length, result = 0;

        for(int num : nums) totalDistinct.add(num);


        for(int right = 0; right < n; right++){
            
            currDistinct.put(nums[right], currDistinct.getOrDefault(nums[right], 0)+1);

            while(currDistinct.size() == totalDistinct.size()){
                result += n - right; // because adding more will also create complete array
                currDistinct.put(nums[left], currDistinct.getOrDefault(nums[left], 0)-1);
                if(currDistinct.get(nums[left])==0) currDistinct.remove(nums[left]);
                left++;
            }
        }

        return result;
    }
}