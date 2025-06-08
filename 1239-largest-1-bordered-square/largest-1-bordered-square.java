class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        
        int rows = grid.length, cols = grid[0].length;
        int[][] rowCount = new int[rows][cols];
        int[][] colCount = new int[rows][cols];
        int maxSquareSide = 0;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j] == 0) continue;

                rowCount[i][j] = (j > 0 ? rowCount[i][j-1] : 0 ) + 1;
                colCount[i][j] = (i > 0 ? colCount[i-1][j] : 0) + 1;

                int possibleSide = Math.min(rowCount[i][j], colCount[i][j]);
                for(int k = possibleSide; k>0; k--){
                    if(rowCount[i-k+1][j] >= k && colCount[i][j-k+1]>=k){
                        maxSquareSide = Math.max(maxSquareSide, k);
                        break;
                    }
                }
            }
        }
        return maxSquareSide*maxSquareSide;
    }
}