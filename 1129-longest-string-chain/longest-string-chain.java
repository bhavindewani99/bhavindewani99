class Solution {
    public int longestStrChain(String[] words) {
        
        int n = words.length;
        int res = 1;
        int[] dp = new int[n];
        for(int i=0;i<n;i++) dp[i]=1;
        Arrays.sort(words, new Comparator<>(){
            @Override
            public int compare(String s1, String s2){
                return s1.length()-s2.length();
            }
        });

        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(check(words[i],words[j]) && dp[i]<1+dp[j]){
                    dp[i]=1+dp[j];
                }
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }

    private boolean check(String s1, String s2) {
        if (s1.length() != s2.length() + 1) return false;
        
        int i = 0, j = 0;
        boolean oneMismatch = false;

        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            } else {
                if (oneMismatch) return false;
                i++;
                oneMismatch = true;
            }
        }

        return true; 
    }
}