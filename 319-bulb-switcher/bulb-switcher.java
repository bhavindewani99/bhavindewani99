class Solution {
    public int bulbSwitch(int n) {
        
        
        if(n==0) return 0;
        int result = 1;

        for(int i=2;i<=n;i++){
            if(isPerfectSquare(i)) result++;
        }
        return result;
    }


    private boolean isPerfectSquare(long number){
        long sqrt = (long) Math.sqrt(number);
        return sqrt * sqrt == number;
    }
}