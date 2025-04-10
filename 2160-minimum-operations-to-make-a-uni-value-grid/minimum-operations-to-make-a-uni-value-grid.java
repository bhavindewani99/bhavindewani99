class Solution {
    public int minOperations(int[][] grid, int x) {
        
        List<Integer> elements = new ArrayList<>();
        int remainder = grid[0][0] % x;
        int operations = 0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] % x != remainder) return -1;
                elements.add(grid[i][j]);
            }
        }

        Collections.sort(elements);
        int median = elements.get(elements.size()/2);

        for(int ele : elements){
            operations += Math.abs(median - ele)/x;
        }

        return operations;

    }
}