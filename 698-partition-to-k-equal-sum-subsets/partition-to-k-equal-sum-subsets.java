class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        
        int n = nums.length, totalSum = 0;

        for(int num : nums) totalSum += num;

        if(totalSum % k != 0) return false;

        boolean[] used = new boolean[n];

        return recursion(0, 0, totalSum/k, k, used, nums);
    }

    private boolean recursion(int index, int currSum, int target, int k, boolean[] used, int[] nums){
        if(k==0) return true;
        if(currSum == target) return recursion(0, 0, target, k-1, used, nums); // we can start from index 0 as previously we might not have used starting elements in building current subset
        
        for(int i=index;i < nums.length;i++){
            if(used[i]==true || currSum + nums[i] > target) continue;
            used[i]=true;

            if(recursion(i+1, currSum+nums[i], target, k, used, nums)==true) return true;

            used[i] = false;
        }
        return false;
    }
}