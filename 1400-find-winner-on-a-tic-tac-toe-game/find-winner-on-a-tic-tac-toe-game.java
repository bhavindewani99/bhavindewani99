class Solution {
    public String tictactoe(int[][] moves) {
        int totalMoves = 0;
        int dia =0, antiDia = 0, val =1, row1=0,row2=0,row3=0,col1=0,col2=0,col3=0;


        for(int[] move : moves){
            if(totalMoves%2==0) val=1;
            else val = -1;

            int r = move[0];
            int c = move[1];

            if(r==c) dia+=val;
            if(r+c==2) antiDia+=val;


            if(r==0) row1+=val;
            else if(r==1) row2+=val;
            else row3+=val;

            if(c==0) col1+=val;
            else if(c==1) col2+=val;
            else col3+=val;

            if(row1==3 || row2==3 || row3==3 || col1==3 || col2==3 || col3==3 || dia==3 || antiDia==3) return "A";

            if(row1==-3 || row2==-3 || row3==-3 || col1==-3 || col2==-3 || col3==-3 || antiDia ==-3 || dia==-3) return "B";

            totalMoves++;
            if(totalMoves==9) return "Draw";

            
        }
        return "Pending";
    }
}