class TicTacToe {
    int[] rows, cols;
    int diagonal, antiDiagonal,n;
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        diagonal = 0;
        antiDiagonal = 0;
        this.n = n;
    }
    
    public int move(int row, int col, int player) {
        int currPlayer = player ==1 ? 1 : -1;
        rows[row] += currPlayer;
        cols[col] += currPlayer;
        if(row==col) diagonal += currPlayer;
        if(row == n - col -1) antiDiagonal+=currPlayer;
        if(Math.abs(rows[row])==n || Math.abs(cols[col])==n || Math.abs(diagonal)==n || Math.abs(antiDiagonal)==n) return player;
        return 0;

    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */