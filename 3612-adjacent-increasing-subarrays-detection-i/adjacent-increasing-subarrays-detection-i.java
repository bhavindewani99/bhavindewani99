class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int prevLongest = 0;
        int currLongest = 1;
        int res = 0;
        for(int i=1;i<nums.size();i++){
            if(nums.get(i-1)<nums.get(i)){
                currLongest++;
            }else{
                prevLongest = currLongest;
                currLongest = 1;
            }
            res = Math.max(res, Math.max(currLongest/2, Math.min(currLongest, prevLongest)));
        }

        return res>=k;
    }
}