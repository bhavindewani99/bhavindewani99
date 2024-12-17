class Solution {
    public int countPalindromes(String s) {
        int mod = (int) 1e9 + 7;
        int n = s.length();

        // Track single-digit counts and two-digit subsequences
        long[] frontCount = new long[10];
        long[] backCount = new long[10];
        long[] frontSub = new long[100];
        long[] backSub = new long[100];

        // Populate backCount and backSub
        for (int i = n - 1; i >= 0; i--) {
            int val = s.charAt(i) - '0';
            for (int j = 0; j < 10; j++) {
                backSub[val * 10 + j] += backCount[j];
                backSub[val * 10 + j] %= mod;
            }
            backCount[val]++;
        }

        long pairs = 0;

        // Traverse the string
        for (int i = 0; i < n; i++) {
            int val = s.charAt(i) - '0';

            // Remove current character from backCount and backSub
            backCount[val]--;
            for (int j = 0; j < 10; j++) {
                if(backCount[j]>0){
                    backSub[val * 10 + j] -= backCount[j];
                    if (backSub[val * 10 + j] < 0) backSub[val * 10 + j] += mod;
                }
                
            }

            // Calculate pairs
            for (int k = 0; k < 100; k++) {
                int reverseNum = (k%10)*10 + k/10;
                pairs += (frontSub[k] * backSub[reverseNum]) % mod;
                pairs %= mod;
            }

            // Update frontCount and frontSub
            for (int j = 0; j < 10; j++) {
                if(frontCount[j]>0){
                    frontSub[j * 10 + val] += frontCount[j];
                     frontSub[j * 10 + val] %= mod;
                }
                
            }
            frontCount[val]++;
        }

        return (int) pairs;
    }
}
