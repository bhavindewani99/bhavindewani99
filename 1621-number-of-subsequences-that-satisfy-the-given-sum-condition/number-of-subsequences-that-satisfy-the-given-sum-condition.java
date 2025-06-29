class Solution {
    public int numSubseq(int[] nums, int target) {
        
        Arrays.sort(nums);
        int n = nums.length, result =0, left =0, right = n-1, mod = (int) 1e9 + 7;
        int[] power = new int[n];
        power[0] = 1;

        for(int i=1;i<n;i++){
            power[i] = (power[i-1] * 2) % mod;
        }

        while (left<=right) {
            if(nums[left] + nums[right] <= target){
                result = (result + power[right - left]) % mod;
                left++;
            }else{
                right--;
            }
        }
        return result;
    }
}