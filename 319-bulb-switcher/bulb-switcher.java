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

// Pattern is we have to find out how many times each bulb will be toggled
// If any number is perfect square then it will be togged odd times
// Eg -> n = 4 (factors:- 1, 2 , 4), n=9 (factors:- 1, 3, 9)
// If number is not perfect square it will haeve even factors means toggled even times
// Eh -> n = 8 (factors:- 1, 2, 4, 8), n=7 (factors: - 1, 7)

// Another solution is basically as we are counting number of perfect squares 
// So suppose n = 27 so perfect squares present will be (1, 4 , 9, 16, 25) means squares of (1,2,3,4,5) which is basically square root of 27 because nxt square will be greater than 27 so answer will be squareRoot(n)