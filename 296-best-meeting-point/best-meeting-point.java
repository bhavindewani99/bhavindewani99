class Solution {
    public int minTotalDistance(int[][] grid) {
        List<Integer> xList = new ArrayList<>();
        List<Integer> yList = new ArrayList<>();
        int n = grid.length;
        int m = grid[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    xList.add(i);
                    yList.add(j);
                }
            }
        }

        Collections.sort(xList);
        Collections.sort(yList);

        int x = xList.get(xList.size()/2);
        int y = yList.get(yList.size()/2);
        System.out.print("x is "+x +" y is "+y);
        int sum = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    sum += (Math.abs(i-x) + Math.abs(j-y));
                }
            }
        }

        return sum;
    }
}