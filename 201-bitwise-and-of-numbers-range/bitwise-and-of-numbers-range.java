class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        
        int result = 0;

        for(int i=31;i>=0;i--){
            if(((1<<i) & left) != ((1<<i) & right)) break;
            boolean isBitSet = ((1<<i) & left) != 0;
            if(isBitSet) result = result | (1<<i);
        }

        return result;
    }
}