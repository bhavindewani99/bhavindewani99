class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        Pair[][] pairs = new Pair[m][n];

        int[][] directions = {{0,-1},{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1}};

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int dead =0, live =0;
                for(int d=0;d<8;d++){
                    int r = i + directions[d][0];
                    int c = j + directions[d][1];
                    if(r>=0 && c>=0 && r<m && c<n){
                        if(board[r][c]==1) live++;
                        else dead++;
                    }
                }
                pairs[i][j] = new Pair(dead, live);
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==0){
                    if(pairs[i][j].live==3) board[i][j]=1;
                }else{
                    if(pairs[i][j].live<2) board[i][j] = 0;
                    else if(pairs[i][j].live>=2 && pairs[i][j].live<=3) continue;
                    else if(pairs[i][j].live>3) board[i][j] = 0;
                }
            }
        }

        
    }

    class Pair{
        int dead, live;
        Pair(int dead, int live){
            this.dead = dead;
            this.live = live;
        }
    }
}