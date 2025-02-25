class Solution {
    public int numOfSubarrays(int[] arr) {
        
        // Check subarrays ending at that element
        // Maintain prefix sum if currSum is even then check how many odd prefix array we can remove to make curr Sum as odd
        // If currSum is odd add 1 to the result and check how many even subarray we can remove from the currSum to make currSum odd

        int prefixSum = 0, evenPrefix = 0, oddPrefix=0, result =0;
        int mod = (int) 1e9 + 7;

        for(int i=0;i<arr.length;i++){
            prefixSum += arr[i];
            if(prefixSum%2 == 0) {
                result = (result + oddPrefix) % mod;
                evenPrefix++;
            }else{
                result = (result + evenPrefix + 1) % mod;
                oddPrefix++;
            }
        }
        return result;
    }
}