class Solution {
    public long zeroFilledSubarray(int[] nums) {
        
        long result = 0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0) continue;
            long start = i;
            while(i<nums.length && nums[i]==0) i++;
            long len = i - start;
            result += (len*(len+1))/2;
            i--;
        }

        return result;
    }
}