class Solution {
    public int largestCombination(int[] candidates) {
        int setBits = 0;
        int maxSetBits = 0;

        for(int i=0;i<32;i++){
            for(int candidate : candidates){
                if((candidate & (1<<i)) >0 ){
                    setBits++;
                }
            }
            maxSetBits = Math.max(maxSetBits, setBits);
            setBits = 0;
        }
        return maxSetBits;
    }
}