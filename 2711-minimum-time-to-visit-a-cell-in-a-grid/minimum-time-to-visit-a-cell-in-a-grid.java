class Solution {
    public int minimumTime(int[][] grid) {

        if(grid[0][1]>1 && grid[1][0]>1) return -1;

        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.time - b.time);
        int[][] directions = {{-1,0}, {0,1}, {1,0}, {0,-1}};

        pq.offer(new Pair(0,0,0));

        while(!pq.isEmpty()){
            Pair pair = pq.poll();
            int r = pair.r;
            int c = pair.c;
            int time = pair.time;

            if(r==n-1 && c== m-1) return time;
            for(int i=0;i<4;i++){
                int x = r + directions[i][0];
                int y = c + directions[i][1];
                if(x<0 || y<0 || x>=n || y>=m || visited[x][y]) continue;
                int wait = 0;
                if(Math.abs(grid[x][y]-time)%2==0) wait =1;

                int newTime = Math.max(grid[x][y] + wait, time + 1);
                pq.offer(new Pair(x, y, newTime));
                visited[x][y] = true;

            }
        }
        return -1; 
    }

    class Pair{
        int r, c, time;
        Pair(int r, int c, int time){
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }
}