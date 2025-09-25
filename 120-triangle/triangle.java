class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        return tabulation(triangle);
        // int maxCol = 0;
        // int n = triangle.size();
        // for(List<Integer> tri : triangle) maxCol = Math.max(maxCol, tri.size());
        // Integer[][] dp = new Integer[n+1][maxCol+1];


        // return recusrion(0,0,triangle, dp);
    }

    private int recusrion(int row, int col, List<List<Integer>> triangle, Integer[][] dp){
        if(row == triangle.size() || col == triangle.get(row).size()) return 0;

        if(dp[row][col] != null) return dp[row][col];

        int curr = triangle.get(row).get(col) + Math.min(recusrion(row +1, col, triangle, dp), recusrion(row+1, col+1, triangle, dp));

        return dp[row][col] = curr;
    }

    private int tabulation(List<List<Integer>> triangle) {
        int n = triangle.size();
        Integer[][] dp = new Integer[n][triangle.get(n-1).size()+1];

        // Start from the last row
        for (int col = 0; col < triangle.get(n - 1).size(); col++) {
            dp[n - 1][col] = triangle.get(n - 1).get(col);
        }

        // Fill upwards
        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col < triangle.get(row).size(); col++) {
                dp[row][col] = triangle.get(row).get(col) +
                    Math.min(dp[row + 1][col], dp[row + 1][col + 1]);
            }
        }

        return dp[0][0];
    }

}