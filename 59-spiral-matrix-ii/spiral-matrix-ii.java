class Solution {
    public int[][] generateMatrix(int n) {
        
        int rowStart =0, colStart = 0, rowEnd = n, colEnd = n;
        int number = 1;
        int[][] grid = new int[n][n];

        while(rowStart<rowEnd && colStart < colEnd){

            for(int col = colStart;col<colEnd;col++){
                grid[rowStart][col] = number++;
            }
            rowStart++;

            for(int row=rowStart;row<rowEnd;row++){
                grid[row][colEnd-1] = number++;
            }
            colEnd--;

            if(rowStart<rowEnd){
                for(int col=colEnd-1;col>=colStart;col--){
                    grid[rowEnd-1][col] = number++;
                }
                rowEnd--;
            }
            
            if(colEnd>colStart){
                for(int row=rowEnd-1;row>=rowStart;row--){
                    grid[row][colStart] = number++;
                }
                colStart++;
            }
        }
        return grid;
    }
}