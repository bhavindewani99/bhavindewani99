class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int n = maze.length;
        int m = maze[0].length;
        boolean[][] visited = new boolean[n][m];
        return dfs(maze,start[0],start[1],destination,visited,n,m);
    }

    private boolean dfs(int[][] maze, int x, int y, int[] destination, boolean[][] visited, int n, int m){
        
        if(x==destination[0] && y==destination[1]){
            return true;
        }
        
        visited[x][y] = true;
       
        int[][] directions = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
        for(int i=0;i<4;i++){
            int r = directions[i][0];
            int c = directions[i][1];
            int newx = x ;
            int newy = y;
            while(newx + r>=0 && newy+c>=0 && newx+r<n && newy+c<m && maze[newx+r][newy+c]==0){
                newx +=r;
                newy+=c;
            }
            if(visited[newx][newy]==false){
                if(dfs(maze, newx, newy, destination, visited, n, m)) return true;
            }
        }
        return false;
    }
}