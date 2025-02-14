class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(entrance);
        maze[entrance[0]][entrance[1]] = '*';
        int m = maze.length;
        int n = maze[0].length;
        int steps = 1;
        int[][] directions = {{0,-1},{-1,0},{0,1},{1,0}};


        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i=0;i<len;i++){
                int x = queue.peek()[0];
                int y = queue.peek()[1];
                queue.poll();

                for(int d=0;d<4;d++){
                    int r = x + directions[d][0];
                    int c = y + directions[d][1];
                    if(r>=0 && c>=0 && r<m && c<n && maze[r][c]=='.'){
                        if(r==0 || r==m-1 || c==0 ||c==n-1) return steps;
                        maze[r][c] = '*';
                        queue.offer(new int[]{r,c});
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}