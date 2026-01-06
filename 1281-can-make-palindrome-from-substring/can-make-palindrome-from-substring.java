class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {

        int n = s.length();
        int[] count = new int[26];
        int[][] dp = new int[n][26];
        List<Boolean> result = new ArrayList<>();

        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            count[c-'a']++;
            for(int j=0;j<26;j++){
                dp[i][j] = count[j];
            }
        }

        for(int[] query : queries){
            int left = query[0], right = query[1];
            int[] curr = new int[26];

            for(int i=0;i<26;i++){
                curr[i] = dp[right][i];
                if(left-1 >= 0) curr[i] -= dp[left-1][i];
            }

            int unique = 0, pair =0, total = 0;
            for(int i=0;i<26;i++){
                if(curr[i] == 0) continue;
                pair += curr[i]/2;
                if(curr[i]%2 !=0) unique++;
            }

            total = pair*2 + unique;
            int requiredK = unique/2;

            if(requiredK > query[2]) result.add(false);
            else result.add(true);
        }

        return result;
    }
}
