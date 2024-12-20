class Solution {
    public int countKDifference(int[] nums, int k) {
        int pairs = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i:nums){
            
            if(map.containsKey(i-k)) pairs+= map.get(i-k);
            if(map.containsKey(i+k)) pairs+= map.get(i+k);
            map.put(i, map.getOrDefault(i, 0) +1);
        }

        return pairs;
    }
}