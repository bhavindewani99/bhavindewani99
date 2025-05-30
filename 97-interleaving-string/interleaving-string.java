class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length()!=s3.length()) return false;
        int[][] memo = new int[s1.length()+1][s2.length()+1];
        for(int[] temp : memo) Arrays.fill(temp, -1);
         return recursion(s1, s2, s3, 0, 0, 0,memo);
    }

    private boolean recursion(String s1, String s2, String s3, int i, int j, int k,int[][] memo){
        if(i==s1.length() && j==s2.length()) return true;

        if(memo[i][j]!=-1) return memo[i][j]==1 ? true : false;
        boolean valid = false;

        if(i<s1.length() && s1.charAt(i)==s3.charAt(k)){
            valid = valid ||  recursion(s1, s2, s3, i+1, j, k+1,memo);
        }
        if(j<s2.length() && s2.charAt(j)==s3.charAt(k)){
            valid = valid || recursion(s1, s2, s3, i, j+1, k+1,memo);
        }
        memo[i][j] = valid ? 1 : 0;
        return valid;
    }
}