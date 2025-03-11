class Solution {
    public long countBadPairs(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        long result = 0;

        for(int i=0;i<nums.length;i++){
            int diff = nums[i] - i;
            result += i - map.getOrDefault(diff, 0);
            map.put(diff, map.getOrDefault(diff, 0) + 1);
        }
        return result;
    }
}