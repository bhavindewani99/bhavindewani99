class Solution {
    public int closedIsland(int[][] grid) {
        
        int m = grid.length, n = grid[0].length;
        int islands = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 0){
                    Pair pair = new Pair();
                    dfs(i, j, m, n, grid, pair);
                    if(validate(m, n, pair)) islands++;
                }
            }
        }

        return islands;

    }

    private boolean validate(int m, int n, Pair pair){
        return pair.leftBorder>0 && pair.topBorder>0 && pair.rightBorder < n-1 && pair.bottomBorder < m-1;
    }

    private void dfs(int r, int c, int m, int n, int[][] grid, Pair pair){
        if(r<0 || c<0 || r>=m || c>=n || grid[r][c]!=0) return;

        pair.leftBorder = Math.min(c, pair.leftBorder);
        pair.rightBorder = Math.max(c, pair.rightBorder);
        pair.topBorder = Math.min(r, pair.topBorder);
        pair.bottomBorder = Math.max(r, pair.bottomBorder);

        grid[r][c] = -1;
        dfs(r+1, c, m, n, grid, pair);
        dfs(r-1, c, m, n, grid, pair);
        dfs(r, c+1, m, n, grid, pair);
        dfs(r, c-1, m, n, grid, pair);
    }

    class Pair{
        int leftBorder = Integer.MAX_VALUE;
        int rightBorder = Integer.MIN_VALUE;
        int topBorder = Integer.MAX_VALUE;
        int bottomBorder = Integer.MIN_VALUE;
    }
}