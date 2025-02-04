class Solution {
    public int maxAscendingSum(int[] nums) {
        int result = 0;
        int sum = 0;
        int last = 0;

        for(int num : nums){
            if(num>last){
                sum += num;
            }else{
                sum = num;
            }
            last = num;
            result = Math.max(result, sum);
        }

        return result;
    }
}