class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        int sum = 0, result = 0, left = 0;

        for(int num : nums){
            sum += num;
            while (seen.contains(num)) {
                sum -= nums[left];
                seen.remove(nums[left]);
                left++;
            }
            seen.add(num);
            result = Math.max(result, sum);
        }
        return result;
    }
}