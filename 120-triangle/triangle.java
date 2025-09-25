class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        int maxCol = 0;
        int n = triangle.size();
        for(List<Integer> tri : triangle) maxCol = Math.max(maxCol, tri.size());
        Integer[][] dp = new Integer[n+1][maxCol+1];


        return recusrion(0,0,triangle, dp);
    }

    private int recusrion(int row, int col, List<List<Integer>> triangle, Integer[][] dp){
        if(row == triangle.size() || col == triangle.get(row).size()) return 0;

        if(dp[row][col] != null) return dp[row][col];

        int curr = triangle.get(row).get(col) + Math.min(recusrion(row +1, col, triangle, dp), recusrion(row+1, col+1, triangle, dp));

        return dp[row][col] = curr;
    }
}