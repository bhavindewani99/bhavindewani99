class Solution {
    public int findLongestChain(int[][] pairs) {
        
        Arrays.sort(pairs, (a,b) -> a[1] - b[1]);
        int lastEnd = Integer.MIN_VALUE;
        int result = 0;

        for(int[] pair : pairs){
            if(pair[0] > lastEnd){
                lastEnd = pair[1];
                result++;
            }
        }
        return result;
    }
}