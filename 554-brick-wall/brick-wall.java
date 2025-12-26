class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        
        int result = 0;
        Map<Long, Integer> map = new HashMap<>(); // sum to count

        for(int i=0;i<wall.size();i++){
            long currSum =0;
            for(int j=0;j<wall.get(i).size()-1;j++){
                currSum += wall.get(i).get(j);
                map.put(currSum, map.getOrDefault(currSum, 0) + 1);
                result = Math.max(result, map.get(currSum));
            }
            
        }

        return wall.size()-result;
    }
}