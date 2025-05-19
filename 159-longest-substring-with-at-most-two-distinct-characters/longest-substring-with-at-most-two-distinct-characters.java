class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        
        Map<Character, Integer> seen = new HashMap<>();
        int left = 0, result = 0;

        for(int right=0;right<s.length();right++){
            seen.put(s.charAt(right), seen.getOrDefault(s.charAt(right), 0) + 1);

            while(seen.size()>2){
                seen.put(s.charAt(left), seen.getOrDefault(s.charAt(left), 0) - 1);
                if(seen.get(s.charAt(left)) == 0) seen.remove(s.charAt(left));
                left++;
            }

            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}