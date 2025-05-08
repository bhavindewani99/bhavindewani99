class Solution {
    public int minTimeToReach(int[][] moveTime) {
        
        // We need to use dikstra to find minimum cost without it time would be O((n*m)^2) using dikstra we can reduce it to  O((n*m)log(m*n))

        int m = moveTime.length, n = moveTime[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2]-b[2]); // row, col, currtime, timeToadd
        visited[0][0] = true;
        pq.offer(new int[]{0,0,0,1});
        int[][] directions = {{-1,0}, {0,1}, {1,0}, {0,-1}};


        while (!pq.isEmpty()) {
            int row = pq.peek()[0], col = pq.peek()[1], currTime = pq.peek()[2], time = pq.peek()[3];
            pq.poll();

            if(row == m-1 && col == n-1) return currTime;

            for(int d=0;d<4;d++){
                int newRow = row + directions[d][0], newCol = col + directions[d][1];

                if(newRow >=0 && newCol>=0 && newRow<m && newCol<n && visited[newRow][newCol]==false){
                    visited[newRow][newCol] = true;
                    int nextCost = Math.max(currTime, moveTime[newRow][newCol]) + time;
                    int newTime = time == 2 ? 1 : 2;
                    pq.offer(new int[]{newRow, newCol, nextCost, newTime});
                }
            }
        }

        return -1;
    }
}