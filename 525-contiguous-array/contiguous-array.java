class Solution {
    public int findMaxLength(int[] nums) {
        
        int res =0, ones =0, zeros= 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) zeros++;
            else ones++;

            int currDiff = ones - zeros;

            map.putIfAbsent(currDiff, i);

            if(zeros == ones) res = zeros + ones;
            else res = Math.max(res, i - map.get(currDiff));
        }

        return res;
    }
}