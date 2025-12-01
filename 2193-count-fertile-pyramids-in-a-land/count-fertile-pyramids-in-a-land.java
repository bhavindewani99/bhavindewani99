class Solution {
    public int countPyramids(int[][] grid) {

        int m = grid.length, n = grid[0].length;
        int pyramids = 0;
        int[][] prefix = new int[m][n];
        fillprefix(grid, prefix, m, n);

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                
                int count = 1;
                int r = i, c1 = j, c2 = j;

                while(r<m && c1>=0 && c2<n){
                    int currOnes = c1-1>=0 ? prefix[r][c2] - prefix[r][c1-1] : prefix[r][c2];

                    if(currOnes == count){
                        if(count > 1) pyramids++;
                    } else break;

                    r++;
                    c1 -= 1;
                    c2 += 1;
                    count += 2;
                }

                count = 1;
                r = i; c1 = j; c2 = j;

                while(r>=0 && c1>=0 && c2<n){
                    int currOnes = c1-1>=0 ? prefix[r][c2] - prefix[r][c1-1] : prefix[r][c2];

                    if(currOnes == count){
                        if(count > 1) pyramids++;
                    } else break;

                    r--;
                    c1 -= 1;
                    c2 += 1;
                    count += 2;
                }
            }
        }
        return pyramids;
    }

    private void fillprefix(int[][] grid, int[][] prefix, int m, int n){
        for(int i=0;i<m;i++){
            int ones = 0;
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1) ones++;
                prefix[i][j] = ones;
            }
        }
    }
}
