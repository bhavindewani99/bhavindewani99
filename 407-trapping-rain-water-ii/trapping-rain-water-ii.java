class Solution {
    public int trapRainWater(int[][] heightMap) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.height - b.height);
        int n = heightMap.length;
        int m = heightMap[0].length;
        boolean[][] visited = new boolean[n][m];

        for(int j=0;j<m;j++){
            pq.offer(new Pair(0,j,heightMap[0][j]));
            pq.offer(new Pair(n-1, j, heightMap[n-1][j]));
            visited[0][j] = true;
            visited[n-1][j] = true;
        }

        for(int i=1;i<n-1;i++){
            pq.offer(new Pair(i,0,heightMap[i][0]));
            pq.offer(new Pair(i, m-1, heightMap[i][m-1]));
            visited[i][0] = true;
            visited[i][m-1] = true;
        }

        int water = 0;
        int[][] directions = {{0,-1}, {-1,0}, {0,1}, {1,0}};

        while(!pq.isEmpty()){
            Pair pair = pq.poll();
            int r = pair.x;
            int c = pair.y;
            int currHeight = pair.height;
            for(int[] dir : directions){
                int x = r + dir[0];
                int y = c + dir[1];
                if(x>0 && y>0 && x<n && y<m && visited[x][y]==false){
                   if(heightMap[x][y] < currHeight){
                        water += currHeight - heightMap[x][y];
                        pq.offer(new Pair(x, y, currHeight));
                   } else{
                        pq.offer(new Pair(x, y, Math.max(currHeight, heightMap[x][y])));
                   }
                   visited[x][y] = true;
                }
            }
        }
        return water;
    }


    class Pair{
        int x, y, height;
        Pair(int x, int y, int height){
            this.x = x;
            this.y = y;
            this.height = height;
        }
    }
}