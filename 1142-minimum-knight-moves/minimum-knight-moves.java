class Solution {
    public int minKnightMoves(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        int[][] directions = {{-2,1},{-2,-1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2}};
        Queue<int[]> queue = new LinkedList<>(); // x, y
        int distance = 0;
        queue.offer(new int[]{0,0});
        Set<String> set = new HashSet<>();
        set.add(0+"^"+0);

        while(!queue.isEmpty()){
            int n = queue.size();
            for(int i=0;i<n;i++){
                int r = queue.peek()[0];
                int c = queue.peek()[1];
                queue.poll();
                if(r==x && c==y) return distance;
                for(int k = 0;k<directions.length;k++){
                    int row = r + directions[k][0];
                    int col = c + directions[k][1];
                    int[] curr = {row, col};
                    if(row>=-2 && col>=-2 && set.contains(row+"^"+col)==false){
                        queue.offer(curr);
                        set.add(row+"^"+col);
                    }
                }
            }   
            distance++;
        }
        return -1;

    }
}