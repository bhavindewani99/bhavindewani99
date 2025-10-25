class Solution {
    public int minCost(int[][] grid) {

        int m = grid.length, n = grid[0].length;
        int[][] direction = {{0,0}, {0,1},{0,-1},{1,0},{-1,0}}; // left, right, 
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.moves - b.moves);
        boolean[][] visited = new boolean[m][n];
        
        pq.offer(new Pair(0,0,0));

        while(!pq.isEmpty()){
            Pair pair = pq.poll();
            int x = pair.x, y = pair.y, moves = pair.moves;

            if(x==m-1 && y==n-1) return moves;
            if(visited[x][y]) continue;
            visited[x][y] = true;

            for(int d = 1;d<=4;d++){
                int r = x + direction[d][0] , c = y + direction[d][1];
                if(r>=0 && c>=0 && r<m && c<n){
                    int nextMove = d == grid[x][y] ? 0 : 1;
                    pq.offer(new Pair(r,c,nextMove+moves));
                }
            }
        }
        return -1;
    }

    class Pair{
        int x,y,moves;
        Pair(int x, int y, int moves){
            this.x = x;
            this.y = y;
            this.moves = moves;
        }
    }
}