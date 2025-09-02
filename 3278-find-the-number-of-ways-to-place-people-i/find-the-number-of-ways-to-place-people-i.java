class Solution {
    public int numberOfPairs(int[][] points) {
        
        int pairs = 0;

        for(int i=0;i<points.length;i++){
            int basex = points[i][0];
            int basey = points[i][1];
            for(int j=0;j<points.length;j++){
                int currx = points[j][0];
                int curry = points[j][1];
                if(j==i || !(basex <= currx && basey >= curry)) continue;
                boolean inBetween = false;
                for(int k=0;k<points.length;k++){
                    if(k==i || k==j) continue;
                    if(insideRectangle(basex, basey, currx, curry, points[k][0], points[k][1])) {
                        inBetween = true;
                        break;
                    }
                }
                if(inBetween == false) pairs++;
            }
        }
        return pairs;
    }

    public boolean insideRectangle(int x1, int y1, int x2, int y2, int px, int py) {
    // Point case
    if (x1 == x2 && y1 == y2) {
        return px == x1 && py == y1;
    }

    // Vertical line
    if (x1 == x2) {
        return px == x1 && py >= Math.min(y1,y2) && py <= Math.max(y1,y2);
    }

    // Horizontal line
    if (y1 == y2) {
        return py == y1 && px >= Math.min(x1,x2) && px <= Math.max(x1,x2);
    }

    // Normal rectangle
    return (px >= Math.min(x1,x2) && px <= Math.max(x1,x2) &&
            py >= Math.min(y1,y2) && py <= Math.max(y1,y2));
}

}