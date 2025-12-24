class Solution {
    Map<String, Double> map = new HashMap<>();
    public double largestSumOfAverages(int[] nums, int k) {
        return recursion(nums, 0, 0, 0, k);
    }

    private double recursion(int[] nums, int index, double elements, double currSum, int k){
        String key = index + "*" + elements + "*" + currSum +"*" + k;
        if(index == nums.length){
            if(k >= 1 && elements > 0) return currSum / elements;
            return 0;
        }

        if(map.containsKey(key)) return map.get(key);

        double not_take = recursion(nums, index + 1, elements + 1, currSum + nums[index], k);

        double take = 0;
        if(k > 1 && elements > 0){
            take = (currSum / elements) + recursion(nums, index + 1, 1, nums[index], k - 1);
        }
        map.put(key, Math.max(take, not_take));
        return Math.max(take, not_take);
    }
}
