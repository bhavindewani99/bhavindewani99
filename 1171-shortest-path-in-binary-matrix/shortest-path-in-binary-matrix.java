class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        
        int m = grid.length, n = grid[0].length;

        if(grid[0][0]!=0 || grid[m-1][n-1]!=0) return -1;

        int[][] directions = {{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0,1});

        while (!queue.isEmpty()) {
            int len = queue.size();
            for(int i=0;i<len;i++){
                int[] curr = queue.poll();
                int r = curr[0], c= curr[1], dist = curr[2];
                if(r==m-1 && c==n-1) return dist;

                for(int d=0;d<8;d++){
                    int x = r + directions[d][0], y = c + directions[d][1];
                    if(x>=0 && y>=0 && x<m && y<n && grid[x][y]==0){
                        grid[x][y]=1;
                        queue.offer(new int[]{x, y, dist + 1});
                    }
                }
            }
        }
        return -1;
    }
}