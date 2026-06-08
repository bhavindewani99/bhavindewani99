class Solution {
    int result = Integer.MAX_VALUE;
    
    public int minimumMoves(int[][] grid) {
        List<int[]> zeros = new ArrayList<>();
        List<int[]> extras = new ArrayList<>();
        
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(grid[i][j] == 0) {
                    zeros.add(new int[]{i, j});
                } else if(grid[i][j] > 1) {
                    // We only need the coordinates now
                    extras.add(new int[]{i, j}); 
                }
            }
        }
        
        if(zeros.size() == 0) return 0;
        
        recursion(grid, 0, 0, zeros, extras);
        return result;
    }
    
    private void recursion(int[][] grid, int index, int count, List<int[]> zeros, List<int[]> extras) {
        if(index >= zeros.size()) {
            result = Math.min(result, count);
            return;
        }
        
        if(count >= result) return; // Quick optimization
        
        int zerox = zeros.get(index)[0];
        int zeroy = zeros.get(index)[1];
        
        for(int i = 0; i < extras.size(); i++) {
            int x = extras.get(i)[0];
            int y = extras.get(i)[1];
            
            // FIX: A cell cannot give away a stone if it only has 1 left
            if(grid[x][y] <= 1) continue; 
            
            grid[x][y]--; // Take a stone from grid
            
            int distance = Math.abs(zerox - x) + Math.abs(zeroy - y);
            recursion(grid, index + 1, count + distance, zeros, extras);
            
            grid[x][y]++; // Backtrack
        }
    }
}
