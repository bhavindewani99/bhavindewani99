class Solution {
    public long[] resultArray(int[] nums, int k) {
        
        long[] result = new long[k];
        int[] prevCnt = new int[k];

        for(int i=0;i<nums.length;i++){
            int[] currCnt = new int[k];
            currCnt[nums[i]%k]++;

            for(int j=0;j<k;j++){
                if(prevCnt[j] != 0){
                    int currRemainder = (j * (nums[i]%k))% k;
                    currCnt[currRemainder] += prevCnt[j];
                }
            }

            for(int j=0;j<k;j++){
                result[j] += currCnt[j];
                prevCnt[j] = currCnt[j];
            }
        }

        return result;
    }
}

