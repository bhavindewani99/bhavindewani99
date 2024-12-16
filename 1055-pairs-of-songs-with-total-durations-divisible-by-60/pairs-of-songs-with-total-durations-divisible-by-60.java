class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> map = new HashMap<>();
        int pairs = 0;

        for(int i=0;i<time.length;i++){
            int remainder = time[i]%60;
            if(remainder==0) pairs+= map.getOrDefault(remainder, 0);
            else pairs += map.getOrDefault(60-time[i]%60, 0);
            map.put(remainder, map.getOrDefault(remainder, 0) +1);
        }

        return pairs;
    }
}