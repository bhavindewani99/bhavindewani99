class Solution {
    public int shortestBridge(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        boolean found = false;
        Queue<Pair> queue = new LinkedList<>();
        int result = Integer.MAX_VALUE;
        int[][] directions = {{0,-1},{-1,0},{0,1},{1,0}};

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    dfs(i, j, grid, queue, m, n);
                    found = true;
                    break;
                }
            }
            if(found) break;
        }

        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            int r = pair.r, c = pair.c, steps = pair.steps;

            //if(grid[r][c]!=0) continue;
            for(int d=0;d<4;d++){
                int x = directions[d][0] + r;
                int y = directions[d][1] + c;
                if(x>=0 && y>=0 && x<m && y<n && grid[x][y]!=-1){
                    System.out.print("yo ");
                    if(grid[x][y]==1) {
                        result = Math.min(result, steps);
                    }else{
                        queue.offer(new Pair(x, y, steps+1));
                    }
                    grid[x][y]=-1;
                }
            }
        }
        return result;
    }

    private void dfs(int r, int c, int[][] grid, Queue<Pair> queue, int m, int n){
        if(r<0 || c<0 || r>=m || c>=n || grid[r][c]!=1) return;

        queue.offer(new Pair(r, c, 0));
        grid[r][c] = -1;
        dfs(r+1, c, grid, queue, m, n);
        dfs(r, c+1, grid, queue, m, n);
        dfs(r-1, c, grid, queue, m, n);
        dfs(r, c-1, grid, queue, m, n);
    }

    class Pair{
        int r, c, steps;
        Pair(int r, int c, int steps){
            this.r = r;
            this.c = c;
            this.steps = steps;
        }
    }
}