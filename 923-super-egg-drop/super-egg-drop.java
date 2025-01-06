class Solution {
    int[][] dp = new int[101][10001];
    public int superEggDrop(int k, int n) {
        
        for(int[] arr : dp) Arrays.fill(arr, -1);
        return findMoves(k, n);
    }

    private int findMoves(int e, int f){
        if(f==0 || f==1) return f;
        if(e==1) return f;
        if(dp[e][f]!=-1) return dp[e][f];

        int start = 1;
        int end = f;
        int moves = Integer.MAX_VALUE;

        while(start<=end){
            int mid = (start+end)/2;
            int breakEgg = findMoves(e-1, mid-1);
            int notBreak = findMoves(e, f-mid);

            int temp = 1 + Math.max(breakEgg, notBreak);
            moves = Math.min(moves, temp);
            if(breakEgg>=notBreak){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }

        return dp[e][f] = moves;
    }
}