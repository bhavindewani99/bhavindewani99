class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum =0;
        double average = Integer.MIN_VALUE;
        int l =0;

        for(int r=0;r<nums.length;r++){
            sum += nums[r];

            if(r-l+1>k) sum -= nums[l++];

            if(r-l+1 ==k) {
                average = Math.max(average,(sum/k));
            }
        }

        return average;
    }
}