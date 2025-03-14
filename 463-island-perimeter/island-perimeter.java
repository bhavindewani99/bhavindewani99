class Solution {
    public int islandPerimeter(int[][] grid) {
        
        int[][] directions = {{-1,0},{0,1},{1,0},{0,-1}};
        int perimeter = 0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0) continue;
                int currPerimter = 0;
                for(int d=0;d<4;d++){
                    int r = i + directions[d][0];
                    int c = j + directions[d][1];
                    if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c]==0) currPerimter++;
                }
                perimeter += currPerimter;
            }
        }

        return perimeter;
    }
}