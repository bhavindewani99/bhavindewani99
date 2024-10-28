class Solution {
    public int minStickers(String[] stickers, String target) {
        Map<String, Map<Character, Integer>> map = new HashMap<>();
        Map<String, Integer> dp = new HashMap<>();
        dp.put("", 0);

        for(String sticker : stickers){
            Map<Character, Integer> freq = new HashMap<>();

            for(char c : sticker.toCharArray()){
                freq.put(c, freq.getOrDefault(c, 0) +1);
            }
            map.put(sticker, freq);
        }

        int result = dfs(target, map, dp);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int dfs(String target, Map<String, Map<Character, Integer>> map, Map<String, Integer> dp){
        if(dp.containsKey(target)) return dp.get(target);

        int res = Integer.MAX_VALUE;
        Map<Character, Integer> targetCount = new HashMap<>();
        for(char c : target.toCharArray()){
            targetCount.put(c, targetCount.getOrDefault(c, 0) +1);
        }

        for(Map<Character, Integer> sticker : map.values()){
            if(!sticker.containsKey(target.charAt(0))) continue;

            StringBuilder remaining = new StringBuilder();
            for(char c : targetCount.keySet()){
                int remainingCount = targetCount.get(c) - sticker.getOrDefault(c, 0);
                for(int i=0;i<remainingCount;i++) remaining.append(c);
            }

            int usedSticker = dfs(remaining.toString(), map, dp);
            if(usedSticker!=Integer.MAX_VALUE){
                res = Math.min(res, 1 + usedSticker);
            }
        }
        dp.put(target, res);
        return res;
    }
}