class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        if(grid[0][0]==1 || grid[n-1][m-1]==1) return -1;
        Queue<Pair> pq = new LinkedList<>();
        int[][] distance = new int[n][m];
        int[] rows = {-1,-1,0,1,1,1,0,-1};
        int[] cols = {0,1,1,1,0,-1,-1,-1};

        for(int[] temp : distance) Arrays.fill(temp, Integer.MAX_VALUE);
        distance[0][0]=1;
        pq.offer(new Pair(0,0,1));

        while(!pq.isEmpty()){
            int x = pq.peek().x;
            int y = pq.peek().y;
            int dist = pq.peek().dist;
            if(x==n-1 && y==m-1) return dist;
            pq.poll();
            for(int i=0;i<8;i++){
                int r = x + rows[i];
                int c = y + cols[i];
                if(r>=0 && c>=0 && r<n && c<m && grid[r][c]==0){
                    grid[r][c] =1;
                    pq.offer(new Pair(r,c,1+dist));
                    if(r==n-1 && c==m-1) return 1+dist;
                }
            }
        }
        return -1;

    }

    class Pair{
        int x,y,dist;
        Pair(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}