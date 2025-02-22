class TicTacToe {

    int n, diagonal, antidiagonal, turnVal;
    int[] rows, cols;
    public TicTacToe(int n) {
        this.n=n;
        rows = new int[n];
        cols=new int[n];
        diagonal = 0;
        antidiagonal = 0;
        turnVal = 0;

    }
    
    public int move(int row, int col, int player) {
        int currValue = turnVal%2==0 ? 1 : -1;
        turnVal++;
        rows[row] += currValue;
        cols[col] += currValue;
        if(row==col) diagonal+= currValue;
        if(row+col==n-1) antidiagonal += currValue;

        for(int i=0;i<n;i++){
            if(n==Math.abs(rows[i]) || n==Math.abs(cols[i])) return player;
        }

        if(n==Math.abs(diagonal) || n==Math.abs(antidiagonal)) return player;

        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */