class Solution {
    public int equalPairs(int[][] grid) {
        
        Map<String, Integer> map = new HashMap<>();
        int m = grid.length, n = grid[0].length;
        int pairs = 0;

        for(int i=0;i<m;i++){
            String curr = "";
            for(int j=0;j<m;j++){
                curr += grid[i][j] + "*";
            }
            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }

        for(int i=0;i<n;i++){
            String curr = "";
            for(int j=0;j<m;j++){
                curr += grid[j][i] + "*";
            }
            if(map.containsKey(curr)) pairs += map.get(curr);
        }

        return pairs;
    }
}