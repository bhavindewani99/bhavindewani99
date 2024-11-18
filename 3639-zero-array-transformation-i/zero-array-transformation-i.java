class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] prefix = new int[n+1];
        
        for(int i=0;i<queries.length;i++){
            int l = queries[i][0];
            int r = queries[i][1];
            prefix[l]++;
            prefix[r+1]--;
        }

        for(int i=1;i<=n;i++) {
            prefix[i] += prefix[i-1];
        }

        for(int i=0;i<n;i++){
            if(prefix[i]<nums[i]) return false;
        }

        return true;
    }
}