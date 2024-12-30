class Solution {
    public boolean judgeCircle(String moves) {
        int horizontal =0, vertical =0;
        for(char c : moves.toCharArray()){
            if(c=='U') vertical++;
            else if(c=='D') vertical--;
            else if(c=='L') horizontal--;
            else horizontal++;
        }
        return horizontal==0 && vertical==0;
    }
}