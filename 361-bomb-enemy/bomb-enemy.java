class Solution {
    public int maxKilledEnemies(char[][] grid) {
        int maxKill  = 0;
        int m = grid.length, n = grid[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == '0'){
                    maxKill = Math.max(maxKill, count(i,j,grid,m,n));
                }
            }
        }
        return maxKill;
    }

    private int count(int i, int j, char[][] grid, int m, int n){

        int people = 0;

        // left side
        int index = j-1;
        while(index>=0 && grid[i][index]!='W'){
            
            if(grid[i][index] == 'E')
            people++;
            index--;
        }

        //right
        index = j+1;
        while(index<n && grid[i][index]!='W'){
            if(grid[i][index] == 'E')
            people++;
            index++;
        }

        //top
        index=i-1;
        while(index>=0 && grid[index][j]!='W'){
            
            if(grid[index][j] == 'E')
            people++;
            index--;
        }

        //bottom
        index = i+1;
        while(index < m && grid[index][j]!='W'){
            
            if(grid[index][j] == 'E')
            people++;
            index++;
        }
        return people;
    }
}