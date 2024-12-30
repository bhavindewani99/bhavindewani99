class Solution {
    int mod=1000000007;
    public int monkeyMove(int n) {
        long total_ways = findPower(2, n);
        int withoutCollision = 2;

        return (int) (total_ways-withoutCollision + mod) % mod;
    }

    private long findPower(long x, int n){
        if(n==1) return x;
        long half = findPower(x, n/2);
        if(n%2==0) {
            return (half * half)%mod;
        }
        return (half*half*2)%mod;
    }
}
