class Solution {
    public boolean validTicTacToe(String[] board) {
        int[] rows = new int[3];
        int[] cols = new int[3];
        int dia =0;
        int antidia =0;
        int turn = 0;

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[i].charAt(j)=='X'){
                    rows[i]++;
                    cols[j]++;
                    turn++;
                    if(i==j) dia++;
                    if(i+j==2) antidia++;
                }else if(board[i].charAt(j)=='O'){
                    rows[i]--;
                    cols[j]--;
                    turn--;
                    if(i==j) dia--;
                    if(i+j==2) antidia--;
                }
            }
        }

        boolean xwin = rows[0]==3 || rows[1]==3 || rows[2]==3 || cols[0]==3 || cols[1]==3 || cols[2]==3 || dia==3 || antidia==3;
        boolean ywin = rows[0]==-3 || rows[1]==-3 || rows[2]==-3 || cols[0]==-3 || cols[1]==-3 || cols[2]==-3 || dia==-3 || antidia==-3;

        if((xwin && turn==0) || (ywin && turn==1)) return false;

        return (turn==0 || turn==1) && (!xwin || !ywin);

        
    }
}