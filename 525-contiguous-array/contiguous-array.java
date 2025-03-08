class Solution {
    public int findMaxLength(int[] nums) {
        
        // We will keep count of zeros and ones and put difference in map
        // we see that difference again we can make the subarray
        // So we will store difference and indexs where it occurs and we do not overritte is because we want maximum findMaxLength

        int zeros = 0, ones = 0, result = 0;
        HashMap<Integer, Integer> map = new HashMap<>(); // difference is key and index is value
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) zeros++;
            else ones++;

            int currDifference = ones - zeros;
            
            map.putIfAbsent(currDifference, i);

            if(zeros==ones) result = ones + zeros;
            else result = Math.max(result, i - map.get(currDifference));
        }

        return result;
    }
}