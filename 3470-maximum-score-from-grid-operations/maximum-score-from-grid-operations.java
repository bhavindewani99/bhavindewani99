import java.util.Arrays;

class Solution {
    public long maximumScore(int[][] grid) {
        int n = grid.length;
        long[][] prefix = new long[n][n+1];

        // Build column-wise prefix sum
        for(int j = 0; j < n; j++){
            for(int i = 0; i < n; i++){
                prefix[j][i+1] = prefix[j][i] + grid[i][j];
            }
        }

        long[] prevpick = new long[n+1];
        long[] prevskip = new long[n+1];

        Arrays.fill(prevpick, 0);
        Arrays.fill(prevskip, 0);
        prevskip[0] = 0;

        for(int col = 1; col < n; col++){
            long[] currpick = new long[n+1];
            long[] currskip = new long[n+1];

            Arrays.fill(currpick, 0);
            Arrays.fill(currskip, 0);

            for(int curr = 0; curr <= n; curr++){
                for(int prev = 0; prev <= n; prev++){

                    if(curr > prev){
                        long score = prefix[col-1][curr] - prefix[col-1][prev];

                        currpick[curr] = Math.max(currpick[curr], prevskip[prev] + score);
                        currskip[curr] = Math.max(currskip[curr], prevskip[prev] + score);
                    } else {
                        long score = prefix[col][prev] - prefix[col][curr];

                        currpick[curr] = Math.max(currpick[curr], prevpick[prev] + score);
                        currskip[curr] = Math.max(currskip[curr], prevpick[prev]);
                    }
                }
            }

            prevpick = currpick;
            prevskip = currskip;
        }

        long res = Long.MIN_VALUE;
        for(long val : prevpick) res = Math.max(res, val);

        return res;
    }
}