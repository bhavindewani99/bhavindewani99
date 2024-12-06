class Solution {
    public int countBattleships(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int result = 0;
        boolean[][] visited = new boolean[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='X' && visited[i][j]==false){
                    dfs(i, j, board, visited, n, m);
                    result++;
                }
            }
        }
        return result;
    }

    private void dfs(int r, int c, char[][] board, boolean[][] visited, int n, int m){
        visited[r][c] = true;
        int x = r+1;
        while(x<n && board[x][c]=='X'){
            visited[x++][c]=true;
        }
        int y = c+1;
        while (y<m && board[r][y]=='X') {
            visited[r][y++] = true;
        }
    }
}