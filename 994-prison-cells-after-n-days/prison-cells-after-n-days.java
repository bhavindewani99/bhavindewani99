class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        int turn=n%14;
        if (turn==0) turn=14;
        for(int i=1;i<=turn;i++){
            StringBuilder sb= new StringBuilder();
            sb.append('0');
            for(int j=1;j<7;j++){
                if((cells[j-1]==0 && cells[j+1]==0) || (cells[j-1]==1 && cells[j+1]==1) ){
                    sb.append('1');
                }
                else{
                    sb.append('0');
                }
            }
            sb.append(0);
            for(int j=0;j<sb.length();j++){
                cells[j]=sb.charAt(j)-'0';
            }
        }
        return cells;
    }
}