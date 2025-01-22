class Solution {
    public int[][] highestPeak(int[][] isWater) {

        int m = isWater.length;
        int n = isWater[0].length;
        Queue<Pair> queue = new LinkedList<>();
        int[][] directions = {{0,-1},{-1,0},{0,1},{1,0}};

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(isWater[i][j]==1){
                    isWater[i][j] = -1;
                    queue.offer(new Pair(i, j, 0));
                }
            }
        }

        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i=0;i<len;i++){
                Pair pair = queue.poll();
                int x = pair.x;
                int y = pair.y;
                int height = pair.height;
                for(int d=0;d<4;d++){
                    int r = x + directions[d][0];
                    int c = y + directions[d][1];
                    if(r>=0 && c>=0 && r<m && c<n && isWater[r][c]!=-1 && isWater[r][c]==0){
                        isWater[r][c] = 1 + height;
                        queue.offer(new Pair(r,c,1+height));
                    }
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(isWater[i][j]==-1){
                    isWater[i][j] = 0;
                    
                }
            }
        }

        return isWater;
        
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