class Solution {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int m = rowCosts.length;
        int n = colCosts.length;
        int x = startPos[0];
        int y = startPos[1];
        int tx = homePos[0];
        int ty = homePos[1];

        if(x==tx && y==ty) return 0;
        int totalCost = 0;

        if(x<tx){ // increase row
            while(x+1<=tx){
                totalCost += rowCosts[x+1];
                x++;
            }
        }else{
            while(x-1>=tx){
                totalCost += rowCosts[x-1];
                x--;
            }
        }

        if(y<ty){
            while (y+1<=ty) {
                totalCost += colCosts[y+1];
                y++;
            }
        }else{
            while (y-1>=ty) {
                totalCost += colCosts[y-1];
                y--;
            }
        }

        return totalCost;
    }
}