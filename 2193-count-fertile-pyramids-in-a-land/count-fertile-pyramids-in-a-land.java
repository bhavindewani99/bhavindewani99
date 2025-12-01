class Solution {

    int m, n;
    int[][] grid;
    int[][] memoDown;
    int[][] memoUp;

    public int countPyramids(int[][] grid) {

        this.grid = grid;
        m = grid.length;
        n = grid[0].length;

        memoDown = new int[m][n];
        memoUp = new int[m][n];

        int result = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                int hDown = getDown(i, j);
                int hUp = getUp(i, j);

                if(hDown > 1) result += hDown - 1;
                if(hUp > 1) result += hUp - 1;
            }
        }

        return result;
    }

    private int getDown(int i, int j){

        if(i<0 || j<0 || i>=m || j>=n) return 0;
        if(grid[i][j] == 0) return 0;

        if(memoDown[i][j] != 0) return memoDown[i][j];

        if(i == m - 1) return memoDown[i][j] = 1;

        int left = getDown(i + 1, j - 1);
        int mid  = getDown(i + 1, j);
        int right = getDown(i + 1, j + 1);

        return memoDown[i][j] = 1 + Math.min(mid, Math.min(left, right));
    }

    private int getUp(int i, int j){

        if(i<0 || j<0 || i>=m || j>=n) return 0;
        if(grid[i][j] == 0) return 0;

        if(memoUp[i][j] != 0) return memoUp[i][j];

        if(i == 0) return memoUp[i][j] = 1;

        int left = getUp(i - 1, j - 1);
        int mid  = getUp(i - 1, j);
        int right = getUp(i - 1, j + 1);

        return memoUp[i][j] = 1 + Math.min(mid, Math.min(left, right));
    }
}
