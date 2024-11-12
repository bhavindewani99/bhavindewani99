class Solution {
    public boolean primeSubOperation(int[] nums) {
        int n = nums.length;
        int prev = 0;

        for(int i=0;i<n;i++){
            int upperBound = nums[i] - prev;
            int prime = 0;
            for(int j=upperBound-1;j>=2;j--){
                if(isPrime(j)){
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