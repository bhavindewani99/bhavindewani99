class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>(); // Remainder to Count
        map.put(0, 1);
        int result = 0, currSum = 0;

        for(int num : nums){
            currSum += num;

            int currRemainder = (currSum + k) % k;

            if(currRemainder < 0) currRemainder += k;

            result += map.getOrDefault(currRemainder, 0);

            map.put(currRemainder, map.getOrDefault(currRemainder, 0) + 1);
        }

        return result;
    }
}