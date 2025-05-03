class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        
        Map<Integer, List<Pair>> map = new HashMap<>(); // trim values -> all the values

        // We are building map for every trim value 
        // eg num = "123" then in map we are adding 1, 12 and 123 with corresponding trim value
        for(int k =0;k<nums.length;k++){
            String num = nums[k];
            int numLen = num.length();
            for(int i=0;i<numLen;i++){
                String currNumber = num.substring(i,numLen);
                int trimValue = numLen-i;
                map.putIfAbsent(trimValue, new ArrayList<>());
                map.get(trimValue).add(new Pair(currNumber, k));
            }
        }

        for(List<Pair> currList : map.values()) {
            Collections.sort(currList, (a,b) -> a.number.equals(b.number) ? a.index-b.index : a.number.compareTo(b.number));
        }

        int[] result = new int[queries.length];

        for(int i=0;i<result.length;i++){
            int k = queries[i][0], trim =queries[i][1];
            int currResult = map.get(trim).get(k-1).index;
            result[i] = currResult;
        }

        return result;
    }


    class Pair{
        String number;
        int index;
        Pair(String number, int index){
            this.number = number;
            this.index = index;
        }
    }
}
