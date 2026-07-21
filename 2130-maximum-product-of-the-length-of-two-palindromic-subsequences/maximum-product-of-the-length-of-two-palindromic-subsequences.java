class Solution {
    public int maxProduct(String s) {
        int n = s.length();
        int maxMask = 1 << n;
        int[] dp = new int[maxMask];
        int result = 0;

        for(int mask=1;mask<maxMask;mask++){
            if(isPalindrome(mask, s, n)){
                dp[mask] = Integer.bitCount(mask);
            }
        }

        for(int m1 = 1;m1<maxMask; m1++){
            if(dp[m1] == 0) continue;

            for(int m2 = m1+1;m2<maxMask;m2++){
                if((m1 & m2) == 0 ){
                    result = Math.max(result, dp[m1] * dp[m2]);
                }
            }
        }

        return result;
    }


    private boolean isPalindrome(int mask, String s, int n){
        int left = 0, right = n -1;

        while(left < right){

            while(left < right && ((mask & (1 << left)) == 0)) left++;

            while(right > left && ((mask & (1<<right)) == 0)) right--;

            if(s.charAt(left) != s.charAt(right)) return false;

            left++;
            right--;
        }
        return true;
    }
}