class Solution {
    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int sum = 0;

        for(int i : nums){
            sum+=i;
            result = Math.max(result, sum);
            if(sum<0) sum = 0;
        }
        return result;
    }
}