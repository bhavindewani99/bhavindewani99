class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        
        Map<String, Long> dp = new HashMap<>();
        Arrays.sort(satisfaction);
        return (int) recursion(satisfaction, 1, 0, dp);
    }

    private long recursion(int[] satisfaction, int time, int index, Map<String, Long> dp){
        if(index >= satisfaction.length) return 0;

        String key = time + "*" + index;
        if(dp.containsKey(key)) return dp.get(key);

        long not_take = recursion(satisfaction, time, index+1, dp);
        long take = satisfaction[index] * time + recursion(satisfaction, time+1, index+1, dp);

        dp.put(key,Math.max(take, not_take));
        return Math.max(take, not_take);
    }
}