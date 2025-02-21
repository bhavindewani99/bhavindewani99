class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        int n = image.length;
        int m = image[0].length;
        Queue<Pair> queue = new LinkedList<>();
        int[] rows = {-1,0,1,0};
        int[] cols = {0,1,0,-1};

        queue.offer(new Pair(sr,sc));
        int target = image[sr][sc];
        if(target==color) return image;
        image[sr][sc]=color;

        while(!queue.isEmpty()){
            Pair curr = queue.poll();
            int x = curr.x;
            int y = curr.y;
            for(int i =0;i<4;i++){
                int row = x + rows[i];
                int col = y + cols[i];
                if(row>=0 && col>=0 && row<n && col<m && image[row][col]==target){
                    queue.offer(new Pair(row,col));
                    image[row][col]=color;
                }
            }
        }

        return image;
    }

    class Pair{
        int x,y;
        Pair(int x , int y){
            this.x = x;
            this.y = y;
        }
    }
}