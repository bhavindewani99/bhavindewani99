class Solution {
    public long gridGame(int[][] grid) {

        int n = grid[0].length;

        // we will calculate prefix sum of both the rows and will check where did the robots crss each other
        // if robot1 crosses at index i then the robot 2 can take (i+1,n) from 1 st row or (0,i-1) from 2nd row
        // robot2 will take the maximum of this two 
        // robot1 will ask to take the minimum to robot2

        long[] prefix1 = new long[n], prefix2 = new long[n];
        prefix1[0] = grid[0][0];
        prefix2[0] = grid[1][0];

        // calculating prefix
        for(int i=1;i<n;i++){
            prefix1[i] = prefix1[i-1] + grid[0][i];
            prefix2[i] = prefix2[i-1] + grid[1][i];
        }

        long result = Long.MAX_VALUE;

        // every i indicates robot1 crosses at ith index
        for (int i = 0; i < n; i++) {
            long topRemaining = prefix1[n-1] - prefix1[i];
            long bottomRemaining = i-1>=0 ? prefix2[i-1] : 0;
            long robot2Choice = Math.max(topRemaining, bottomRemaining);
            result = Math.min(result, robot2Choice); // robot1 choice
        }

        return result;
    }
}