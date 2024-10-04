class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[arr.length];
        Arrays.fill(dp,-1);
        return recursion(0, arr, k,dp);
    }


    private int recursion(int index, int[] arr, int k,int[] dp){
        if(index==arr.length) return 0;
        if(dp[index]!=-1) return dp[index];
        int maxi = Integer.MIN_VALUE;
        int res= Integer.MIN_VALUE;
        for(int j=index;j<index+k && j<arr.length;j++){
            maxi=Math.max(maxi,arr[j]);
            int cost = maxi*(j-index+1) + recursion(j+1, arr, k,dp);
            res = Math.max(res,cost);
        }
        return  dp[index] = res;
    }
}