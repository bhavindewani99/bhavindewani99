class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long sum =0;
        Set<Integer> set = new HashSet<>();
        long currSum = 0;
        int start = 0;

        for(int i=0;i<nums.length;i++){
            while(set.contains(nums[i])){
                currSum -= nums[start];
                set.remove(nums[start++]);
            }
            set.add(nums[i]);
            currSum += nums[i];
            while(set.size()>k){
                set.remove(nums[start]);
                currSum-=nums[start++];
            }
            if(set.size()==k) sum = Math.max(sum, currSum);
        }
        return sum;
    }
}