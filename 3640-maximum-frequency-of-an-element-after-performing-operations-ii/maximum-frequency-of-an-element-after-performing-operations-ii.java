class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Arrays.sort(nums);
        int n = nums.length;
        int result = 0;
        int left =0, right=0;
        Map<Integer,Integer> freqmMap = new HashMap<>();

        for(int i:nums) freqmMap.put(i, freqmMap.getOrDefault(i, 0) + 1);

        for(int mid=0;mid<n;mid++){
            
            while (nums[mid]-nums[left]>k) {
                left++;
            }
            while(right<n-1 && nums[right+1]-nums[mid]<=k){
                right++;
            }
            int total = right-left+1;
            int needToAdjust = total - freqmMap.get(nums[mid]);
            result = Math.max(result, Math.min(needToAdjust, numOperations) + freqmMap.get(nums[mid]));
        }

        // Now we assume an mid and try to find how many values can be made equal to this mid
        left=0;
        for(right=0;right<n;right++){
            int mid = (nums[left]+nums[right])/2;
            while(mid - nums[left] > k || nums[right] - mid > k){
                left++;
                mid = (nums[left]+nums[right])/2;
            }
            result = Math.max(result, Math.min(numOperations, right-left+1));
        }
        return result;
    }
}