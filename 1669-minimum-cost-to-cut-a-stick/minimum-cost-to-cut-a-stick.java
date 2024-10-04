
class Solution {
    public int minCost(int n, int[] cuts) {
        int c = cuts.length;
        int[] newCuts = new int[c+2];
        for(int i=0;i<c;i++){
            newCuts[i+1] = cuts[i];
        }
        newCuts[c+1] = n;
        Arrays.sort(newCuts);
        return tabulation(c, n, newCuts);
        // int[][] dp = new int[c+1][c+1];
        // for(int[] temp : dp) Arrays.fill(temp, -1);
        // return recursion(1, c, newCuts, n,dp);
    }

    private int tabulation(int c, int n, int[] newCuts){
        int[][] dp = new int[c+2][c+2];
        
        for(int i=c;i>=1;i--){
            for(int j=1;j<=c;j++){
                if(i>j) continue;
                int cost = Integer.MAX_VALUE;
                for(int k=i;k<=j;k++){
                    int curr_cost = newCuts[j+1] - newCuts[i-1] + dp[i][k-1] + dp[k+1][j];
                    cost = Math.min(cost,curr_cost);
                }
                dp[i][j] = cost;
            }
        }

        return dp[1][c];
    }

    private int recursion(int i, int j, int[] newCuts, int n, int[][] dp){
        if(i>j) return 0;
        int cost = Integer.MAX_VALUE;
        if(dp[i][j]!=-1) return dp[i][j];
        for(int k =i;k<=j;k++){
            int curr_cost = newCuts[j+1] - newCuts[i-1] + recursion(i, k-1, newCuts, n,dp) + recursion(k+1, j, newCuts, n,dp);
            cost = Math.min(cost,curr_cost);
        }
        return  dp[i][j] = cost;
    }
}