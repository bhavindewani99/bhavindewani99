class Solution {
    public int minFlips(int[][] grid) {
        int n = grid.length, m = grid[0].length, result = 0;

        // all corner pairs
        for(int i=0;i<n/2;i++){
            for(int j=0;j<m/2;j++){
                int ones = grid[i][j] + grid[n-i-1][j] + grid[i][m-j-1] + grid[n-i-1][m-j-1];
                result += Math.min(ones, 4-ones);

            }
        }

        int onesPair =0, diff =0;
        // center row
        if(n%2==1){
            for(int j=0;j<m/2;j++){
                if(grid[n/2][j] != grid[n/2][m-j-1]) diff++;

                onesPair += (grid[n/2][j] == grid[n/2][m-j-1] && grid[n/2][m-j-1] == 1 ) ? 1 : 0;
            }
        }

        // center col
        if(m%2==1){
            for(int i=0;i<n/2;i++){
                if(grid[i][m/2] != grid[n-i-1][m/2]) diff++;

                onesPair += (grid[i][m/2] == grid[n-i-1][m/2] && grid[n-i-1][m/2] == 1) ? 1 : 0;
            }
        }

        result += diff;
        result += (onesPair % 2 == 1 && diff==0) ? 2 : 0;

        if(m%2 == 1 && n%2 == 1 && grid[n/2][m/2]==1) result++;

        return result; 

    }
}