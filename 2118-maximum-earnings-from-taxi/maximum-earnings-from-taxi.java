class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {

        long[] dp = new long[n+1]; // for storing maximum profit at each index
        Map<Integer, List<int[]>> map = new HashMap<>(); // to store rides ending at this index

        // add rides ending at particular index
        for(int i=0;i<=n;i++) map.put(i, new ArrayList<>());
        for(int[] ride : rides){
           int end = ride[1];
           map.get(end).add(ride);
        } 

        for(int i=1;i<=n;i++){
            dp[i] = dp[i-1];

            for(int[] ride : map.get(i)){
                long start = ride[0], end = ride[1], tip = ride[2];
                dp[i] = Math.max(dp[i], dp[(int)start] + end-start+tip);
            }
        }

        return dp[n];
    }
}