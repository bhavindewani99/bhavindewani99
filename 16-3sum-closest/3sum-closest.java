class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int res = Integer.MAX_VALUE;
        int ansSum = -1;
        Arrays.sort(nums);
        int n = nums.length;

        for(int i=0;i<=n-3;i++){
            int j = i+1;
            int k = n-1;
            while(j<k){
                int sum = nums[i] + nums[j] + nums[k];
                if(res>Math.abs(target-sum)){
                    res = Math.abs(target-sum);
                    ansSum = sum;
                }
                if(sum>target) k--;
                else j++;
            }
        }
        return ansSum;
    }
}