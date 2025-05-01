class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    if(recursion(board,word,0,i,j,visited)) return true;
                }
            }
        }
        return false;
    }

    private boolean recursion(char[][] board, String word,int index,int row,int col,boolean[][] visited){
        if(index==word.length()) return true;

        if(row>=board.length || col>=board[0].length || col<0 || row<0 || visited[row][col]==true || board[row][col] != word.charAt(index)) return false;

        visited[row][col]=true;

        if((recursion(board,word,index+1,row+1,col,visited) ||
            recursion(board,word,index+1,row,col+1,visited) ||
            recursion(board,word,index+1,row-1,col,visited) ||
            recursion(board,word,index+1,row,col-1,visited) ) ==true){
                return true;
        }
        

        visited[row][col]=false;

        return false;
    }
}