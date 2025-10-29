class Solution {
    public int shortestSequence(int[] rolls, int k) {
        Set<Integer> seen = new HashSet<>();
        int minLen = 1;

        for(int roll : rolls){
            seen.add(roll);
            if(seen.size() == k){
                minLen++;
                seen = new HashSet<>();
            }
        }

        return minLen;
    }
}