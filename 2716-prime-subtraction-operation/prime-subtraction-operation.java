class Solution {
    public boolean primeSubOperation(int[] nums) {
        int n = nums.length;
        int prev = 0;
        int maxi = 0;

        for(int i : nums) maxi = Math.max(i,maxi);

        boolean[] primes = new boolean[maxi];
        for(int i=2;i<maxi;i++){
            primes[i] = isPrime(i);
        }

        for(int i=0;i<n;i++){
            int upperBound = nums[i] - prev;
            int prime = 0;
            for(int j=upperBound-1;j>=2;j--){
                if(primes[j]){
                    prime = j;
                    break;
                }
            }
            if(nums[i]-prime<=prev) return false;
            prev = nums[i] - prime;
        }
        return true;
    }

    private boolean isPrime(int num){
        for(int i=2;i*i<=num;i++){
            if(num%i==0) return false;
        }
        return true;
    }
}