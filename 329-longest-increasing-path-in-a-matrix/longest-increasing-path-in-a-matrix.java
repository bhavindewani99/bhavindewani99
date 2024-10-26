class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] distance= new int[n][m];
        int res = 0;

        for(int[] temp: distance) Arrays.fill(temp, -1);

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(distance[i][j]==-1)
                res = Math.max(res, dfs(i, j, matrix, distance, n, m));
            }
        }
        
        return res+1;
    }

    private int dfs(int x, int y, int[][] matrix, int[][] distance, int n, int m){
        if(distance[x][y]!=-1) return distance[x][y];
        int[] rows = {-1,0,1,0};
        int[] cols = {0,1,0,-1};
        int maxDistance = 0;
        for(int i=0;i<4;i++){
            int row = x + rows[i];
            int col = y + cols[i];
            if(row>=0 && col>=0 && row<n && col<m  && matrix[row][col]>matrix[x][y]){
                maxDistance = Math.max(maxDistance, 1 + dfs(row, col, matrix, distance, n, m));
            } 
        }
        distance[x][y] = maxDistance;
        return maxDistance;
    }
}