class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int l = 0;
        int r = queries.length;
        int result = -1;
        while(l<=r){
            int mid = (l+r)/2;
            if(possible(nums,queries,n,mid)){
                result = mid;
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return result;
    }

    private boolean possible(int[] nums, int[][] queries, int n, int k){
        int[] prefix = new int[n+1];

        for(int i=0;i<k;i++){
            int l = queries[i][0];
            int r = queries[i][1];
            int val = queries[i][2];
            prefix[l] += val;
            prefix[r+1] -= val;
        }

        for(int i=1;i<n;i++){
            prefix[i] += prefix[i-1];
        }

        for(int i=0;i<n;i++){
            if(nums[i]>prefix[i]) return false;
        }
        return true;
    }
}