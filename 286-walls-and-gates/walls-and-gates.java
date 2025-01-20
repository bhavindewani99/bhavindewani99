class Solution {
    public void wallsAndGates(int[][] rooms) {
        
        int m = rooms.length;
        int n = rooms[0].length;
        Queue<Pair> queue = new LinkedList<>();
        int[][] directions = {{0,-1},{-1,0},{0,1},{1,0}};

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(rooms[i][j]==0){
                    queue.offer(new Pair(i, j ,0));
                }
            }
        }

        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i=0;i<len;i++){
                Pair pair = queue.poll();
                int x = pair.x;
                int y = pair.y;
                int dist = pair.dist;
                for(int d =0;d<4;d++){
                    int r = x + directions[d][0];
                    int c = y + directions[d][1];
                    if(r>=0 && c>=0 && r<m && c<n && rooms[r][c]!=-1 && dist+1<rooms[r][c]){
                        rooms[r][c] = 1 + dist;
                        queue.offer(new Pair(r,c,dist+1));
                    }
                }

            }
        }
    }

    class Pair{
        int x, y, dist;
        Pair(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}