class Solution {
    public int numSubseq(int[] nums, int target) {
    
        Arrays.sort(nums);
        
        int MOD = 1000000007;
        int n = nums.length;
        int[] power = new int[n];
        power[0] = 1;
        
        for (int i = 1; i < n; i++) {
            power[i] = (power[i - 1] * 2) % MOD;
        }
        
        long res = 0;
        int l = 0, r = n - 1;
        
        while (l <= r) {
            if (nums[l] + nums[r] <= target) {
                // Add valid subsequences count
                res = (res + power[r - l]) % MOD;
                l++;
            } else {
                r--;
            }
        }
        
        return (int) res;
    }
}