class Solution {
    int[][] directions= {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0];
        int y = click[1];
        int n = board.length;
        int m = board[0].length;
        if(board[x][y]=='M' || board[x][y]=='X') {
            board[x][y] = 'X';
            return board;
        }
        dfs(board, x, y, n, m);
        return board;
    }

    private void dfs(char[][] board, int x, int y, int n, int m){
        if(x<0 || y<0 || x>=n || y>=m || board[x][y]!='E') return;

        int num = getNumberOfAdjacentBombs(board,x,y,n,m);
        if(num>0){
            board[x][y] = (char)(num + '0');
        }else{
            board[x][y] = 'B';
            for(int i=0;i<8;i++){
                dfs(board, x + directions[i][0], y + directions[i][1], n, m);
            }
        }
    }

    private int getNumberOfAdjacentBombs(char[][] board, int x, int y, int n, int m){
        int bombs = 0;
        for(int i=0;i<8;i++){
            int r = x + directions[i][0];
            int c = y + directions[i][1];
            if(r>=0 && c>=0 && r<n && c<m && (board[r][c]=='M' || board[r][c]=='X')) bombs++;
        }
        return bombs;
    }
}