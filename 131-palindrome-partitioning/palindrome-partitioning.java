class Solution {
    public List<List<String>> partition(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        List<List<String>> res = new ArrayList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                if(s.charAt(i)==s.charAt(j) &&  (i-j<=2 || dp[j+1][i-1])) dp[j][i] = true;
            }
        }

        recursion(s, 0, res, new ArrayList<>(), dp);
        return res;

    }

    private void recursion(String s,int index, List<List<String>> res, List<String> temp,boolean[][] dp){
        if(index==s.length()){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=index;i<s.length();i++){
            if(dp[index][i]){
                temp.add(s.substring(index,i+1));
                recursion(s, i+1, res, temp, dp);
                temp.remove(temp.size()-1);
            }
        }
    }
}