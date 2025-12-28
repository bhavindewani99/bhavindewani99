class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> countmap = new HashMap<>();
        Map<Integer, Integer> endmap = new HashMap<>();

        for(int num : nums) countmap.put(num, countmap.getOrDefault(num,0) +1);

        for(int num : nums){
            if(countmap.get(num) == 0) continue;

            // check if we can extend a subsequence
            if(endmap.getOrDefault(num-1, 0) > 0){
                endmap.put(num-1, endmap.getOrDefault(num-1, 0) - 1); // means there is not subsequece ending at num - 1
                endmap.put(num, endmap.getOrDefault(num, 0) + 1); // there is a subsequenc ending at num 
            } else if(countmap.getOrDefault(num+1,0)>0 && countmap.getOrDefault(num+2,0)> 0){ // start a new sequence
                endmap.put(num+2, endmap.getOrDefault(num+2, 0) + 1);
                countmap.put(num+1, countmap.getOrDefault(num+1, 0) - 1);
                countmap.put(num+2, countmap.getOrDefault(num+2, 0) - 1);
            } else{ // cannot proceed further
                return false;
            }
            countmap.put(num, countmap.getOrDefault(num,0) -1);
        }

        return true;
    }
}