class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        
        List<Boolean> result = new ArrayList<>();
        int n = s.length();
        int[] prefix = new int[n+1];

        for(int i=0;i<n;i++){
            int currBit = 1 << (s.charAt(i)-'a');
            prefix[i+1] = prefix[i] ^ currBit;
        }

        for(int[] query : queries){
            int l = query[0], r = query[1], k = query[2];

            int currBits = prefix[r+1] ^ prefix[l];
            int setBits = 0;
            for(int i=0;i<26;i++){
                if((currBits & (1<<i)) !=0 ) setBits++;
            }
            setBits/=2;
            if(setBits > k) result.add(false);
            else result.add(true);
        }
        return result;
    }
}

