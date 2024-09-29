class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] dp = new int[n];
        int[] hash = new int[n];
        List<Integer> res = new ArrayList<>();
        int maxi = 1;
        int startIndex = 0;

        for(int i=0;i<n;i++){
            dp[i]=1;
            hash[i]=i;
        }

        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0 && dp[i]<1+dp[j]){
                    dp[i]=dp[i]+1;
                    hash[i]=j;
                }
            }
            if(maxi<dp[i]){
                maxi = dp[i];
                startIndex=i;
            }
        }

        while(true){
            res.add(nums[startIndex]);
            if(startIndex==hash[startIndex]) break;
            startIndex=hash[startIndex];
        }
        return res;


    }
}