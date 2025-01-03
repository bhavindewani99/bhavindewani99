class Solution {

    int mod = (int) 1e9 + 7;
    int n = 23;
    int[][][] dp = new int[2][n][200];
    String s;
    int max_sum, min_sum;

    public int count(String num1, String num2, int min_sum, int max_sum) {
        this.max_sum = max_sum;
        this.min_sum = min_sum;

        int numbersLessThanEqualTONum2 = goodIntegersLessThanEqualToX(num2);
        int numbersLessThanEqualTONum1 = goodIntegersLessThanEqualToX(subtractOne(num1));

        return (numbersLessThanEqualTONum2 - numbersLessThanEqualTONum1 + mod) % mod;
    }

    private int goodIntegers(boolean isSmaller, int index, int sum){
        if(index == s.length()){
            return sum>=min_sum && max_sum>=sum ? 1 : 0;
        }

        if(dp[isSmaller ? 1 : 0][index][sum] !=-1) return dp[isSmaller ? 1: 0][index][sum];

        int result = 0;
        int start = 0, end = isSmaller ? 9 : s.charAt(index) - '0';

        for(int i = start; i<=end; i++){
            result = (result + goodIntegers(isSmaller || (i<end), index+1, sum+i)) % mod;
        }

        dp[isSmaller ? 1 : 0][index][sum] = result;

        return result;
    }

    private int goodIntegersLessThanEqualToX(String x){
        for(int[][] level2 : dp){
            for(int[] level1 : level2) Arrays.fill(level1, -1);
        }

        buildS(x);
        return goodIntegers(false, 0, 0);
    }

    private String subtractOne(String x){
        int len = x.length();
        char[] arr = x.toCharArray();

        int lastNonZeroIndex = len-1;
        while(lastNonZeroIndex>=0 && arr[lastNonZeroIndex]=='0') lastNonZeroIndex--;

        if(lastNonZeroIndex>=0){
            arr[lastNonZeroIndex]--;
            for(int j= lastNonZeroIndex+1;j<len;j++){
                arr[j] = '9';
            }
        }
        return new String(arr);

    }

    private void buildS(String x){
        int len = x.length();
        StringBuilder builder = new StringBuilder();
        for(int j=0;j<(n-len);j++) builder.append('0');
        builder.append(x);
        s = builder.toString();
    }
}