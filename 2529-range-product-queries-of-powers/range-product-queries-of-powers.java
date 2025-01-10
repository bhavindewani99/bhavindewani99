class Solution {
    public int[] productQueries(int n, int[][] queries) {
        // Define the modulus as a long to prevent precision issues
        long MOD = 1_000_000_007;
        
        // List to store the exponents of 2 where the bits in n are set
        LinkedList<Integer> exponents = new LinkedList<>();
        int exponent = 0;
        
        // Extract exponents from the binary representation of n
        while(n > 0){
           if((n & 1) == 1)
               exponents.add(exponent); // Store the exponent where bit is set
           exponent++;
           n >>= 1; // Shift n to process the next bit
        }
        
        // Compute the prefix sums of exponents to allow range sum queries
        int size = exponents.size();
        for(int i = 1; i < size; i++){
            exponents.set(i, exponents.get(i - 1) + exponents.get(i));
        }

        // Initialize the result array
        int[] results = new int[queries.length];
        int resultIndex = 0;
        
        // Process each query to compute the product of powers of 2 in the range
        for(int[] query : queries){
            int left = query[0];
            int right = query[1];
            
            // Calculate the sum of exponents in the range [left, right]
            long sumOfExponents;
            if(left > 0){
                sumOfExponents = (long)exponents.get(right) - exponents.get(left - 1);
            }
            else{
                sumOfExponents = (long)exponents.get(right);
            }
            
            // Compute 2^(sumOfExponents) modulo MOD
            //long product = modularExponentiation(2, sumOfExponents, MOD);
            long product = findPower(2, sumOfExponents, MOD);
            results[resultIndex] = (int)product;
            resultIndex++;
        }
        return results;
    }

    // Helper method to perform modular exponentiation
    private long modularExponentiation(long base, long exponent, long mod){
        long result = 1;
        base = base % mod;
        while(exponent > 0){
            if((exponent & 1) == 1){
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exponent >>= 1;
        }
        return result;
    }


    private long findPower(long x, long n, long mod) {
    if (n == 0) return 1;  // Base case for exponent 0 (any number to the power of 0 is 1)
    if (n == 1) return x % mod;  // Return x % mod if n is 1
    
    long half = findPower(x, n / 2, mod) % mod;  // Recursively find the power of the half exponent
    if (n % 2 == 0) {
        return (half * half) % mod;  // If n is even, square the result and apply modulus
    }
    return (half * half * x) % mod;  // If n is odd, square the result and multiply by x, then apply modulus
}

}
