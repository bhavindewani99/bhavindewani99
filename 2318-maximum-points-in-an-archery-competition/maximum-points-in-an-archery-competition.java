class Solution {
    int[] result;
    int max = 0;
    public int[] maximumBobPoints(int n, int[] aliceArrows) {
        result = new int[12];
        int[] bob = new int[12];
        recursion(0, n, aliceArrows, 0, bob);
        return result;
    }

    private void recursion(int index, int n, int[] aliceArrows, int currSum, int[] bob){
        if(index == 12){
            if(currSum > max){
                max = currSum;
                int x = n;
                for(int i=0;i<12;i++){
                    result[i] = bob[i];
                    if(bob[i] > aliceArrows[i]) {
                        result[i] += x;
                        x = 0;
                    }
                }
            }
            return;
        }

        // not take 
        recursion(index + 1, n, aliceArrows, currSum, bob);

        // take
        if(n > aliceArrows[index]){
            bob[index] = aliceArrows[index] + 1;
            n -= aliceArrows[index] + 1;
            recursion(index + 1, n, aliceArrows, currSum + index, bob);
            bob[index] -= aliceArrows[index] + 1;
        }
    }
}