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

// Logic is we are trying to find out possible subarrays with all the remainders ending at the current element
// Eg -> nums = [1,2,3,4,5], k = 3 suppose pointer is at 3 means nums[3] = 4
// then we will try to find out all subarrays ending at 4 with all possible remainders

