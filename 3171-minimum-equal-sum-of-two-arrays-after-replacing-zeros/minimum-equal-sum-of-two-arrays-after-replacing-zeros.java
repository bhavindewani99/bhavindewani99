class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        
        // First we calculate sum and count of zeros from both arrays
        // now we have to replace every zero with a number so we assume that we replace with 1
        // So we get updated sum from both arrays
        // If sum1 > sum2 means there should be atleast one zero to make sum2 equal to sum1 and viceverca
        long sum1 = 0, sum2 =0;
        int count1 =0, count2 = 0;

        for(int num : nums1){
            if(num == 0) count1++;
            sum1 += num;
        }

        for(int num : nums2){
            if(num == 0) count2++;
            sum2 += num;
        }

        sum1 += count1;
        sum2 += count2;

        if(sum1 == sum2 ) return sum1;
        else if(sum1 < sum2 && count1>0) return sum2;
        else if(sum1 > sum2 && count2>0) return sum1;

        return -1; 
    }
}