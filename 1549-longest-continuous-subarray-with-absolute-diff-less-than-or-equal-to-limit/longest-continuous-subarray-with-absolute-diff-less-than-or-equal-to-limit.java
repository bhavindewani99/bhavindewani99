class Solution {
    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int start =0;
        int res = 0;

        for(int i=0;i<nums.length;i++){
            while(map.isEmpty()==false && (Math.abs(map.firstKey()-nums[i])>limit || Math.abs(map.lastKey()-nums[i])> limit)){
                int key = nums[start++];
                if(map.containsKey(key)){
                    if(map.get(key)==1) map.remove(key);
                    else map.put(key, map.get(key)-1);
                }
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
            res = Math.max(res,i-start+1);
        } 
        return res;
    }
}