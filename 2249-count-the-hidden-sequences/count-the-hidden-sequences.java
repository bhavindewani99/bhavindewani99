class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        
        // We have give an range(upper-lower)
        // Suppose we assume starting value as x and find out the minimum x value as maximum x value we will also get one range which we have to fit in the given range so we will able to move our range in th give range

        long minVal = 0, maxVal =0, currVal =0;

        for(int i=0;i<differences.length;i++){
            currVal += differences[i];
            minVal = Math.min(minVal, currVal);
            maxVal = Math.max(maxVal, currVal);
        }

        long possibleSeq = (upper - lower) - (maxVal - minVal) + 1;// +1 bcz we of the inclusive part

        return possibleSeq > 0 ? (int) possibleSeq : 0;
    }
}