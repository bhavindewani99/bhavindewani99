class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n-k+1];
        int l =0;
        int conse_cnt = 1;

        for(int r=0;r<n;r++){
            if(r>0 && nums[r-1]+1 == nums[r]) conse_cnt++;

            if(r-l+1 > k){
                if(nums[l]+1 == nums[l+1]) conse_cnt--;
                l++;
            }

            if(r-l+1==k){
                if(conse_cnt==k) res[l] = nums[r];
                else res[l] = -1;
            }
        }

        return res;
    }
}