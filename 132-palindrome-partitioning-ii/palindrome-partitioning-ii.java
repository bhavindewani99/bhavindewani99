class Solution {
    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return recursion(0, s, n,dp)-1;
    }

    private int recursion(int index, String s, int n, int[] dp){
        if(index==n) return 0;
        if(dp[index]!=-1) return dp[index];
        int cost = Integer.MAX_VALUE;
        for(int j=index;j<n;j++){
            if(palindrome(index,j,s)){
                int curr_cost = 1 + recursion(j+1, s, n,dp);
                cost = Math.min(cost,curr_cost);
            }
            
        }
        return dp[index] = cost;
    }

    private boolean palindrome(int i, int j, String s){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}