class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int result = 0;
        Map<String, Integer> map = new HashMap<>();

        for(int[] curr : matrix){
            String key = "";
            if(curr[0]==0) {
                key = Arrays.toString(curr);
            }else{
                for(int i=0;i<curr.length;i++){
                    curr[i] = 1- curr[i];
                }
                key = Arrays.toString(curr);
            }
            map.put(key, map.getOrDefault(key, 0) + 1);
            result = Math.max(result, map.get(key));
        }
        return result;
    }
}