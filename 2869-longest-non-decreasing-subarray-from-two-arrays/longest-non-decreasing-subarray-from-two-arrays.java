class Solution {
    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {
        
        int n = nums1.length;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);
        int maxLength = 1;

        for(int i=1;i<n;i++){
            if(nums1[i] >= nums1[i-1]){
                dp1[i] = 1 + dp1[i-1];
            }
            if(nums1[i] >= nums2[i-1]){
                dp1[i] = Math.max(1+dp2[i-1], dp1[i]);
            }
            if(nums2[i] >= nums2[i-1]){
                dp2[i] = 1 + dp2[i-1];
            }
            if(nums2[i] >= nums1[i-1]){
                dp2[i] = Math.max(1+dp1[i-1], dp2[i]);
            }
            maxLength=Math.max(maxLength, Math.max(dp1[i], dp2[i]));
        }
        return maxLength;
    }
}