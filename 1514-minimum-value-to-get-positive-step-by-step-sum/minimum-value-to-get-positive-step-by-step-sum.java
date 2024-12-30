class Solution {
    public int minStartValue(int[] nums) {
        int sum = 0;
        int mini = Integer.MAX_VALUE;
        for(int i : nums){
            sum +=i;
            mini = Math.min(mini, sum);
        }
        if(mini>0) return 1;
        return -1*mini + 1;
    }
}