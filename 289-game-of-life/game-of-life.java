class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        //bruteForceSolution(board, m, n);
        OptimalSoluiton(board, m, n);
        
    }

    // Optimal Solution we dont need to createextra matrix we can use bits
    // if curr element is 1 then we will count number of lives if is>=2 and <=3 then we set the 2nd bit so int value will be 3 because -> 11
    // if element is 0 then we will count number of live neighbour if it exactly 3 then we set the 2nd bit so int value will become 2 beacuse -> 10
    private void OptimalSoluiton(int[][] board, int m, int n){
        int[][] directions = {{0,-1},{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1}};

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int live =0;
                for(int d=0;d<8;d++){
                    int r = i + directions[d][0];
                    int c = j + directions[d][1];
                    if(r>=0 && c>=0 && r<m && c<n){
                        if((board[r][c] & 1) ==1) live++;
                    }
                }
                if(board[i][j]==1 && live>=2 && live<=3) board[i][j]=3;
                if(board[i][j]==0 && live==3) board[i][j]=2;
            }
        }


        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]>1) board[i][j]=1;
                else board[i][j] = 0;
            }
        }
    }


    private void bruteForceSolution(int[][] board, int m, int n){
        int[][] pairs = new int[m][n];

        int[][] directions = {{0,-1},{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1}};

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int live =0;
                for(int d=0;d<8;d++){
                    int r = i + directions[d][0];
                    int c = j + directions[d][1];
                    if(r>=0 && c>=0 && r<m && c<n){
                        if(board[r][c]==1) live++;
                    }
                }
                pairs[i][j] = live;
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==0){
                    if(pairs[i][j]==3) board[i][j]=1;
                }else{
                    if(pairs[i][j]<2) board[i][j] = 0;
                    else if(pairs[i][j]>=2 && pairs[i][j]<=3) continue;
                    else if(pairs[i][j]>3) board[i][j] = 0;
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