class Solution {
    public int countPairs(int[] deliciousness) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        int mod = (int)1e9 + 7;

        // powers of two up to 2 * max value (max = 2^20)
        for(int dec : deliciousness){
            int power = 1;
            for(int i = 0; i <= 21; i++){  // 2^21 > 2 * 10^5
                int remainder = power - dec;
                if(map.containsKey(remainder)){
                    result = (result + map.get(remainder)) % mod;
                }
                power <<= 1; // multiply by 2
            }
            map.put(dec, map.getOrDefault(dec, 0) + 1);
        }

        return result;
    }
}
