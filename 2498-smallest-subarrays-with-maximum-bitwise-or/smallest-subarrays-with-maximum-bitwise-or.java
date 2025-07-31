class Solution {
    public int[] smallestSubarrays(int[] nums) {
        
        int n = nums.length;
        int[] nextSetBit = new int[32];
        Arrays.fill(nextSetBit, n);
        int[] result = new int[n];

        for(int i=n-1;i>=0;i--){
            int maxLength = i;
            for(int j=0;j<32;j++){
                if((nums[i] & (1<<j)) != 0){
                    nextSetBit[j] = i;
                }else if(nextSetBit[j] != n){
                    maxLength = Math.max(maxLength, nextSetBit[j]);
                }
            }
            result[i] = maxLength - i + 1;
        }
        return result;
    }
}