class Solution {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int m = grid.length, n = grid[0].length;
        int defaultColor = grid[row][col];
        boolean[][] visited = new boolean[m][n];
        List<int[]> borders = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        visited[row][col] = true;
        
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int r = temp[0], c = temp[1];
            boolean isBorder = false;
            
            for (int[] d : directions) {
                int x = r + d[0], y = c + d[1];
                if (x<0 || y<0 || x>=m || y>=n || grid[x][y] != defaultColor) {
                    isBorder = true;
                } else if (!visited[x][y]) {
                    visited[x][y] = true;
                    queue.offer(new int[]{x, y});
                }
            }
            
            if (isBorder) borders.add(new int[]{r, c});
        }
        
        for (int[] cell : borders) {
            grid[cell[0]][cell[1]] = color;
        }
        return grid;
    }
}
