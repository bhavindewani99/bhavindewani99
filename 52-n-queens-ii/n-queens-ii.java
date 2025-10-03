class Solution {
    public int totalNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        return backtrack(0,n,board);
    }

    private int backtrack(int col, int n, boolean[][] board){
        if(col == n) return 1;

        int ans = 0;

        for(int row = 0; row<n;row++){
            if(possible(board,row,col,n)){
                board[row][col] = true;
                ans = ans + backtrack(col+1,n,board);
                board[row][col] = false;
            }
        }
        return ans;
    }

    private boolean possible(boolean[][] board, int row, int col, int n){

    // check row on the left side
    for(int i=0; i<col; i++){
        if(board[row][i]) return false;
    }

    // check upper-left diagonal
    for(int i=row, j=col; i>=0 && j>=0; i--, j--){
        if(board[i][j]) return false;
    }

    // check lower-left diagonal
    for(int i=row, j=col; i<n && j>=0; i++, j--){
        if(board[i][j]) return false;
    }

    return true;
}



}